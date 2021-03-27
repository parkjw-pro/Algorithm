package com.ssafy;



import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Problem_2667 {
	
	static int M,N;
	static char map[][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static boolean vis[][];
	static int cnt[];
	static int index = 0;
	static int count;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sc.nextLine();

		map = new char[N][N];
		vis = new boolean[N][N];
		cnt = new int[250];
		int total = 0;
		
		
		
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '1'&& !vis[i][j]) {
					count = 0;
					total++ ;
					bfs(i, j);
					pq.add(count);}
			}
		}
		System.out.println(total);
		
		while(!pq.isEmpty())
           System.out.println(pq.poll());
		
		sc.close();
	}
	private static void bfs(int n, int m) {
		Queue<island>  queue= new LinkedList<island>();
		
		vis[n][m] = true;
		queue.offer(new island(n,m));
		count = count + 1;
		
		while(!queue.isEmpty()) {
		
			island is = queue.poll();
		
			for (int i = 0; i < 4; i++) {
				
				int ny = is.N_number + dy[i];
				int nx = is.M_number + dx[i];
				
				if(ny>=0&&nx>=0&&ny<N&&nx<N&&!vis[ny][nx]&&map[ny][nx]=='1') {
					vis[ny][nx] = true;
					queue.offer(new island(ny,nx));
					count++;
				}
			}
		}
		return;
	}
    static class island{
    	int N_number;
    	int M_number;
        public  island(int N_number, int M_number){
            this.N_number = N_number;
            this.M_number = M_number;
        }
    }
}