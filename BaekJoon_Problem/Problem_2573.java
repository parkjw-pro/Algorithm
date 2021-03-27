package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2573 {
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	static int N,M,map[][], mapc[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		mapc = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]!=0) {
					queue.offer(i);
					queue.offer(j);
				}
			}
		}
		mapc = map;
		
		bfs();
	}
	
	public static void bfs() {
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size/2; i++) {
				int ci = queue.poll();
				int cj = queue.poll();
				
				for (int j = 0; j < dx.length; j++) {
					
					int ny = ci+dy[j];
					int nx = cj+dx[j];
					if(map[ny][nx]==0) {
						
						mapc[ci][cj] = map[ci][cj]-1;
					}
				}
			}
			map= mapc;
			
		}
	}
}