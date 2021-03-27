package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_5653_줄기세포배양 {
	
	static class cell{
		int i;
		int j;
		int wait;
		int live;
		int left;
		public cell(int i, int j, int wait, int live, int left) {
			super();
			this.i = i;
			this.j = j;
			this.wait = wait;
			this.live = live;
			this.left = left;
		}
	}
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int check[][];
	static int N,M,K;
	static Queue<cell> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		
		for (int test = 1; test <= T; test++) {
			
			queue = new LinkedList<cell>();
			N = sc.nextInt(); 
			M = sc.nextInt(); 
			K = sc.nextInt(); 
			check = new int[N+M+K+2][N+M+K+2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int a = sc.nextInt();
					if(a>0) {
						queue.add(new cell(i,j,a,a,a));
						check[i+K/2][j+K/2] = 11;
					}
				}
			}
			
			bfs();
			
			System.out.println("#"+test+" "+queue.size());
		}
	}
	private static void bfs() {
		int cnc=0;
		int time = 0;
		while(true) {
			if(time==K) {break;}
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				cell c = queue.poll();
				if(c.wait>0) {
					queue.offer(new cell(c.i,c.j,c.wait-1,c.live,c.left));
					continue;
				}
				if(c.left-1!=0) {
				
				//	System.out.println("hhh"+c.wait);
					queue.offer(new cell(c.i,c.j,c.wait,c.live,c.left-1));
				}
				
				for (int j = 0; j < 4; j++) {
					
					int ny = c.i + dy[j];
					int nx = c.j + dx[j];
			
					if(check[ny+K/2][nx+K/2]>=c.live) continue;
					else{
						check[ny+K/2][nx+K/2] = c.live;
					}
				}
			}

			for (int i = 0; i < check.length; i++) {
				for (int j = 0; j < check.length; j++) {
					if(check[i][j]>0&&check[i][j]!=11) {
						
						queue.offer(new cell(i-K/2,j-K/2, check[i][j], check[i][j],check[i][j]));
						
						//지금 문제가., 일단 wait를 가지고들어가야하고, live도 새로운건 그대로고 원래있던 세포만 줄어들어야함.
						check[i][j] =11;
						
					}
				}
			}
		//	System.out.println(count);
			time = time +1;
		}

	}

}
