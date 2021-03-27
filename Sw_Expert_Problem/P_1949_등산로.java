package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_1949_등산로 {
	
	static int N,K;
	static int arr[][], arr2[][];
	static int max,answer;
	static Queue<Integer> queue;
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static boolean vis[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			N = sc.nextInt();
			K = sc.nextInt();
			answer = 0;
			max = 0;
			queue = new LinkedList<Integer>();
			arr = new int[N][N];
			arr2 = new int[N][N];
			vis= new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					arr[i][j] = sc.nextInt();
					
					//가장 높은 봉우리 갱신
					if(max<arr[i][j]) {
						max = arr[i][j];
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == max) {
						queue.add(i);
						queue.add(j);
					}
				}
			}
			while(!queue.isEmpty()) {
				int n = queue.poll();
				int m = queue.poll();
				vis= new boolean[N][N];
				vis[n][m] = true;
				//dfs(n,m,K,1,arr[n][m]);
				bfs(n,m);
				//vis[n][m] = false;
				
			}
			System.out.println("#"+t+" "+answer);
		}
	}
	private static void dfs(int n, int m, int k, int count, int height) {
		if(answer<count) {
			answer = count;
		}
		for (int i = 0; i < 4; i++) {
			int nn = n + dy[i];
			int nm = m + dx[i];
			if(nn<0||nn>=N||nm<0||nm>=N||vis[nn][nm]) continue;
			
			//공사없이 가능
			if(arr[nn][nm]<height) {
				vis[nn][nm] = true;
				dfs(nn, nm, k, count + 1, arr[nn][nm]);
				vis[nn][nm] = false;
				
			}else {
				if((arr[nn][nm]-height+1)<=k) {
					vis[nn][nm] = true;
					dfs(nn, nm, 0, count+1, height-1);
					vis[nn][nm] = false;
				}
			}
		}
	}
	private static void bfs(int n, int m) {
		Queue<Integer> queue2 = new LinkedList<Integer>();
		
		queue2.add(n);
		queue2.add(m);
		queue2.add(K);
		queue2.add(1);
		queue2.add(arr[n][m]);
		arr2[n][m] = 1;		
		while(!queue2.isEmpty()) {
			
			int r = queue2.poll();
			int c = queue2.poll();
			int kk = queue2.poll();
			int count = queue2.poll();
			int height = queue2.poll();
			
			if(answer<count) {
				answer = count;
			}
			
			for (int i = 0; i < 4; i++) {
				int nn = r + dy[i];
				int nm = c + dx[i];
				if(nn<0||nn>=N||nm<0||nm>=N) continue;
				
				if(vis[nn][nm]&&arr2[nn][nm]>count) continue;
				
				//공사없이 가능
				if(arr[nn][nm]<height) {
					vis[nn][nm] = true;
					queue2.add(nn);
					queue2.add(nm);
					queue2.add(kk);
					queue2.add(count+1);
					queue2.add(arr[nn][nm]);
					arr2[nn][nm] = count;
				}else {
					if((arr[nn][nm]-height+1)<=kk) {
						vis[nn][nm] = true;
						queue2.add(nn);
						queue2.add(nm);
						queue2.add(0);
						queue2.add(count+1);
						queue2.add(height-1);
						arr2[nn][nm] = count;
					}
				}
			}
			
			
		}
		
	}
}
