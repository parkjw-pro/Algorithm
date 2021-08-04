package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_2636_치즈 {
	
	static int N;
	static int M;
	static int arr[][];
	static int arrc[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static Queue<Integer> queue = new LinkedList<Integer>();
	static boolean vis[][];
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N][M];
		arrc = new int[N][M];
		int count = 0;
		int answer2 = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				arrc[i][j] = arr[i][j];
			}
		}
		int answer = 0;
		
		while(true) {
			boolean flag = false;
			boolean flag2 = false;
			count = 0;
			//공간에 대한 정의
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j]==0&&!flag) {
						bfs(i,j);
						flag = true;
						break;

					}
				}
				if(flag)break;
			}
			
			
			
			//현재 arrc는 내부공기 체크되어있는 상태
			
			//치즈에 대한 정의
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j]==1) {
						count++;
						flag2 = true;
						for (int k = 0; k < 4; k++) {
							int ni = i + dy[k];
							int nj = j + dx[k];
							if(ni<0||nj<0||ni>=N||nj>=M) continue;
							
							if(arrc[ni][nj]==-1) {
								arr[i][j] = 0;
								break;
							}
						}

					}
				}
			}
			answer++;
			answer2 = count;
			boolean fin = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j]==1) {
						fin = false;
						break;
					}
					if(!fin) break;
				}
			}
			if(fin) break;
			if(!flag2) break;
			
			//배열 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arrc[i][j] = arr[i][j];
				}
			}
			
		}
		System.out.println(answer);
		System.out.println(answer2);
	}
	private static void bfs(int r, int c) {
		queue.clear();
		vis = new boolean[N][M];
		queue.add(r);
		queue.add(c);
		vis[r][c] = true;
		while(!queue.isEmpty()) {
			
			
			int n = queue.poll();
			int m = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int ni = n + dy[i];
				int mi = m + dx[i];
				//끝점에 도달 -> 외부공기
				if(ni<0||mi<0||ni>=N||mi>=M) continue;
				if(vis[ni][mi]||arr[ni][mi]==1) continue;
				queue.add(ni);
				queue.add(mi);
				vis[ni][mi] = true;
				arrc[ni][mi] = -1;
			}
		}
		//내부공기
		return;
	}
}