package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_17086_아기상어2 {
	
	static int N;
	static int M;
	static int arr[][];
	static int dx[] = {-1,-1,-1,0,1,1,1,0};
	static int dy[] = {-1,0,1,1,1,0,-1,-1};
	static int answer = 0;
	static boolean vis2[][] = new boolean[N][M];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				vis2 = new boolean[N][M];
				if(arr[i][j]!=1) {
					bfs(i,j);
				}
				
			}
		}
		System.out.println(answer);
		
				
	}
	private static void bfs(int n, int m) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(n);
		queue.add(m);
		queue.add(0);
		
		vis2[n][m] = true;
		
		while(!queue.isEmpty()) {
			
			int nn = queue.poll();
			int mm = queue.poll();
			int count = queue.poll();
			
			for (int i = 0; i < dx.length; i++) {
				
				int ci = nn + dx[i];
				int cj = mm + dy[i];
				
				if(ci<0||cj<0||ci>=N||cj>=M||vis2[ci][cj]) {
					continue;
				}
				
				if(arr[ci][cj]==1) {
					answer = Math.max(answer, count+1);
					return;
				}else {
					vis2[ci][cj] = true;
					queue.add(ci);
					queue.add(cj);
					queue.add(count+1);
				}
			}
			
		}
		
		
	}

}
