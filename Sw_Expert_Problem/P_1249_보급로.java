package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class P_1249_보급로 {
     
    static int N,arr[][];
    static int vis[][];
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int inf = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; //new StringTokenizer(in.readLine());
         
        int T = Integer.parseInt(in.readLine());
         
        for (int test = 1; test <= T; test++) {
             
            N = Integer.parseInt(in.readLine());
            arr = new int[N][N];
            vis = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    vis[i][j] = inf;
                }
            }
            for (int i = 0; i < N; i++) {
                String s = in.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j)-48;
                }
            }
             
          //  bfs();
             
          //  System.out.println("#"+test+" "+vis[N-1][N-1]);
          //  System.out.println("#"+test+" "+dijkstra(0,0,N-1,N-1));
            System.out.println("#"+test+" "+dijkstrapq(0,0,N-1,N-1));
        }
 
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
         
        queue.offer(0);
        queue.offer(0);
        queue.offer(0);
        vis[0][0] = 0;
         
        while(!queue.isEmpty()) {
            int y = queue.poll();
            int x = queue.poll();
            int cost = queue.poll();
             
            for (int i = 0; i < 4; i++) {
                 
                int ny = y + dy[i];
                int nx = x + dx[i];
                 
                if(ny<0||nx<0||ny>=N||nx>=N) continue;
                 
                if(vis[ny][nx]>cost+arr[ny][nx]) {
                     
                    vis[ny][nx] = cost+arr[ny][nx];
                    queue.offer(ny);
                    queue.offer(nx);
                    queue.offer(cost+arr[ny][nx]);
                }
            }
        }
    }
    
    private static int dijkstra(int sx, int sy, int ex, int ey) {
    	int minTime[][] = new int[N][N];
    	boolean vis[][] = new boolean[N][N];
    	
    	//모든 최소비용을 최대 값으로 초기화
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = inf;
			}
		}
    	minTime[sx][sy] = 0;
    	
    	int r=0,c=0,cost=0,nr,nc;
    	while(true) {
    		cost = inf;
    		//1. 미방문 정점 중 최소비용의 정점 찾기.
    		for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!vis[i][j]&&cost>minTime[i][j]) {
						cost = minTime[i][j];
						r = i;
						c = j;
					}
				}
			}
    		vis[r][c] = true;
    		//선택된 정점이 도착정점이면 끝난다.
    		if(r==ex && c ==ey) return cost;
    		for (int i = 0; i < 4; i++) {
				nr = r + dy[i];
				nc = c + dx[i];
				if(nr<0||nc<0||nr>=N||nc>=N||vis[nr][nc]||
						minTime[nr][nc]<= cost + arr[nr][nc]) continue;
				
				minTime[nr][nc] = cost + arr[nr][nc];
			}
    	}		
	}
    
    private static int dijkstrapq(int sx, int sy, int ex, int ey) {
    	int minTime[][] = new int[N][N];
    	boolean vis[][] = new boolean[N][N];
    	
    	//모든 최소비용을 최대 값으로 초기화
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = inf;
			}
		}
    	PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2]; // 오름차순의 결과
			}
    		
    		
		});
    	
    	minTime[sx][sy] = 0;
    	pq.offer(new int[] {sx,sy,0});
    	
    	int r=0,c=0,cost=0,nr,nc,current[];
    	while(true) {

    		current = pq.poll();
    		r = current[0];
    		c = current[1];
    		cost = current[2];
    		
    		if(vis[r][c]) continue;
    		
    		vis[r][c] = true;
    		//선택된 정점이 도착정점이면 끝난다.
    		if(r==ex && c ==ey) return cost;
    		for (int i = 0; i < 4; i++) {
				nr = r + dy[i];
				nc = c + dx[i];
				if(nr<0||nc<0||nr>=N||nc>=N||vis[nr][nc]||
						minTime[nr][nc]<= cost + arr[nr][nc]) continue;
				
				minTime[nr][nc] = cost + arr[nr][nc];
				
				//갱신된 최소비용을 pq에 넣어준다.
				pq.offer(new int[] {nr, nc, minTime[nr][nc]});
			}
    	}		
	}
}