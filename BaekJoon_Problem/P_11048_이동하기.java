package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_11048_이동하기 {
	
	static int dy[] = {1,0,1};
	static int dx[] = {0,1,1};
	static int N,M;
	static int arr[][];
	static boolean vis[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		vis = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] =sc.nextInt();
			}
		}
		bfs();
		

	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		Queue<Integer> count = new LinkedList<Integer>();
		
		queue.add(0);
		queue2.add(0);
		count.add(0);
		
		while(!queue.isEmpty()) {
			
			int ci = queue.poll();
			int cj = queue2.poll();
			int cnt = count.poll();
			
			for (int i = 0; i < 3; i++) {
				
				int ny = ci + dy[i];
				int nx = cj + dx[i];
				
				if(ny<0||nx<0||ny>=N||nx>=M||vis[ny])
				
			}
		}
	}

}
