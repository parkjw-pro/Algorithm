package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P_21610_마법사상어와비바라기 {
	
	static class magic{
		int d;
		int s;
		public magic(int d, int s) {
			super();
			this.d = d;
			this.s = s;
		}
		
	}
	
	static int N;
	static int M;
	static int arr[][];
	static int answer;
	static int dy[]= {0,-1,-1,-1,0,1,1,1};
	static int dx[]= {-1,-1,0,1,1,1,0,-1};
	static List<magic> list;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][N];
		list = new ArrayList<magic>();
		queue = new LinkedList<Integer>();
		answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < M; i++) {
			int d = sc.nextInt()-1;
			int s = sc.nextInt();
			list.add(new magic(d,s));
		}
		
		//비바라기 시전
		queue.add(N-1);
		queue.add(0);
		queue.add(N-1);
		queue.add(1);
		queue.add(N-2);
		queue.add(0);
		queue.add(N-2);
		queue.add(1);
		int arrc[][];
		
		for (magic m : list) {
			Queue<Integer> watercopy = new LinkedList<Integer>();
			int size = queue.size()/2;
			boolean vis[][] = new boolean[N][N];
			for (int k = 0; k < size; k++) {
				//첫번째 구름에 대하여
				
				int r = queue.poll();
				int c = queue.poll();
				
				int nr = r + dy[m.d]*m.s;
				int nc = c + dx[m.d]*m.s;
				
				if(nr<0) {
					if(Math.abs(nr)%N==0) {
						nr = 0;
					}else{
						nr = N - Math.abs(nr)%N;
					}
					
				}else {
					nr = nr%N;
				}
				if(nc<0) {
					if(Math.abs(nc)%N==0) {
						nc = 0;
					}else{
						nc = N - Math.abs(nc)%N;
					}
				}else {
					nc = nc%N;
				}
				//구름이 뭉쳐있으면
				if(vis[nr][nc]) continue;
				vis[nr][nc] = true;
				arr[nr][nc]++;
				watercopy.add(nr);
				watercopy.add(nc);
			}
			
			arrc = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arrc[i][j] = arr[i][j];
				}
			}
			boolean vis2[][] = new boolean[N][N];
			size = watercopy.size()/2;
			for (int i = 0; i < size; i++) {
				int r = watercopy.poll();
				int c = watercopy.poll();
				if(vis2[r][c]) continue;
				vis2[r][c] = true;
				int count = 0;
				for (int k = 1; k < 8; k=k+2) {
					int nr = r + dy[k];
					int nc = c + dx[k];
					if(nr<0||nc<0||nr>=N||nc>=N||arr[nr][nc]==0) continue;
					if(arr[nr][nc]>0) count++;
				}
				arrc[r][c] = arr[r][c] + count;

			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = arrc[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]>=2&&!vis[i][j]) {
						queue.add(i);
						queue.add(j);
						arr[i][j] = arr[i][j] -2;
					}
				}
			}
			
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer = answer + arr[i][j];
			}
		}
		System.out.println(answer);
		
				

	}

}
