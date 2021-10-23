package com.ssafy;

import java.util.Scanner;

public class P_14500_테트로미노 {
	
	static int N;
	static int M;
	static int arr[][];
	static boolean vis[][];
	static int answer ;
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		N = sc.nextInt();
		M = sc.nextInt();
		answer = 0;
		arr = new int[N][M];
		vis = new boolean[N][M];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				vis[i][j] = true;
				dfs(i,j,arr[i][j],1);
				vis[i][j] = false;
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				vis[i][j] = true;
//				dfs2(i,j,arr[i][j],1);
//				vis[i][j] = false;
//			}
//		}
		System.out.println(answer);

	}
	private static void dfs(int r, int c, int sum, int cnt) {
		if(cnt==2) {
			int k = 0;
			for (int i = 0; i < 4; i++) {
				int nr = r + dy[i];
				int nc = c + dx[i];
				
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(vis[nr][nc]) {
					k = i;
					break;
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = i; j < 4; j++) {
					if(i==k||j==k) continue;
					if(i==j) continue;
					if(r+dy[i]<0||r+dy[i]>=N||c+dx[i]<0||c+dx[i]>=M||r+dy[j]<0||r+dy[j]>=N||c+dx[j]<0||c+dx[j]>=M) {
						continue;
					}
					answer = Math.max(answer, sum+arr[r+dy[i]][c+dx[i]]+arr[r+dy[j]][c+dx[j]]);
					
				}

			}
		}
		
		if(cnt==4) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dy[i];
			int nc = c + dx[i];
			
			if(nr<0||nc<0||nr>=N||nc>=M||vis[nr][nc]) continue;
			vis[nr][nc] = true;
			dfs(nr,nc,sum+arr[nr][nc],cnt+1);
			vis[nr][nc] = false;
			
		}
		
	}
	private static void dfs2(int r, int c, int sum, int cnt) {
		if(cnt==2) {
			int k = 0;
			for (int i = 0; i < 4; i++) {
				int nr = r + dy[i];
				int nc = c + dx[i];
				
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(vis[nr][nc]) {
					k = i;
					break;
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = i; j < 4; j++) {
					if(i==k||j==k) continue;
					if(i==j) continue;
					answer = Math.max(answer, sum+arr[r+dy[i]][c+dx[i]]+arr[r+dy[j]][c+dx[j]]);
					
				}

			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dy[i];
			int nc = c + dx[i];
			
			if(nr<0||nc<0||nr>=N||nc>=M||vis[nr][nc]) continue;
			vis[nr][nc] = true;
			dfs(nr,nc,sum+arr[nr][nc],cnt+1);
			vis[nr][nc] = false;
			
		}
		
	}

}
