package com.ssafy;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2468 {
	
	static int N,map[][],mapc[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static boolean vis[][];
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		int min = 0;
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]>max){ max =  map[i][j];}
			}
		}
		//PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int maxc = 0;
		for (int h = 0; h <= max; h++) {
			int count = 0;
			vis = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!vis[i][j]&&map[i][j]>h) {
						
						BFS(i,j,h);
						count +=1;
						
					}
				}
			}
			if(count>maxc) { maxc = count;}
		}
		System.out.println(maxc);
	}
	public static void BFS(int i, int j, int h) {
		Queue<Integer> queue = new LinkedList<Integer>();
		vis[i][j] = true;
		queue.offer(i);
		queue.offer(j);
		
		while(!queue.isEmpty()) {
			
			int current_i = queue.poll();
			int current_j = queue.poll();
			
			for (int k = 0; k < dx.length; k++) {
				
				int ny = current_i+dy[k];
				int nx = current_j+dx[k];
				
				if(ny>=0&&nx>=0&&ny<N&&nx<N&&!vis[ny][nx]&&map[ny][nx]>h) {
					
					vis[ny][nx]= true;
					queue.offer(ny);
					queue.offer(nx);
				}
			}
		}
	}
}