package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_14503 {
	
	static int N,M,map[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int s_i = sc.nextInt();
		int s_j = sc.nextInt();
		int dir = sc.nextInt();
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==0) {count = count+1;}
			}
		}
		bfs(s_i,s_j,dir);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {count = count -1;}
			}
		}
		System.out.println(count);
		
	}
	public static void bfs(int si, int sj, int dir) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(si);
		queue.offer(sj);
		queue.offer(dir);
		map[si][sj] = 2;
		
		while(!queue.isEmpty()) {
			
			int ci = queue.poll();
			int cj = queue.poll();
			int cdir = queue.poll();
			
			map[ci][cj] = 2;
			int fourdir = 0;
			while(true) {
				if(fourdir==4) {
					ci = ci+dy[(cdir+2)%4];
					cj = cj+dx[(cdir+2)%4];
					fourdir=0;
					if(map[ci][cj]==1) { return;}
				}
				if(map[ci+dy[(cdir+3)%4]][cj+dx[(cdir+3)%4]]==0) {
					queue.offer(ci+dy[(cdir+3)%4]);
					queue.offer(cj+dx[(cdir+3)%4]);
					queue.offer((cdir+3)%4);
					break;
				}
					cdir = (cdir+3)%4;
					fourdir++;
			}
		}
	}
}	