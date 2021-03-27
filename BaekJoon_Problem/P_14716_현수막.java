package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_14716_현수막 {
	
	static int N,M;
	static int arr[][];
	static boolean vis[][];
	static int answer = 0;
	static int dy[] = {-1,-1,-1,0,1,1,1,0};
	static int dx[] = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M= sc.nextInt();
		N= sc.nextInt();
		
		arr = new int[M][N];
		vis = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==1) {
					
				}
			}
		}
		
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!vis[i][j]&&arr[i][j]==1) {
				bfs(i,j);
				answer ++;
				}
			}
		}
		
		System.out.println(answer);
		

	}

	private static void bfs(int i, int j) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(i);
		queue.add(j);
		
		while(!queue.isEmpty()) {
			int ci = queue.poll();
			int cj = queue.poll();
			
			for (int k = 0; k < 8; k++) {
				int ny = ci + dy[k];
				int nx = cj + dx[k];
				
				if(ny<0||nx<0||ny>=M||nx>=N||vis[ny][nx]||arr[ny][nx]==0) {
					continue;
				}
				vis[ny][nx] = true;
				queue.add(ny);
				queue.add(nx);
				
			}
			
			
			
		}
		
	}

}
