package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_17144_미세먼지안녕 {
	
	static class dust{
		int i;
		int j;
		int size;
		public dust(int i, int j, int size) {
			super();
			this.i = i;
			this.j = j;
			this.size = size;
		}
	}
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	
	static int R,C,T,map[][],mapc[][];
	static int clean_i,clean_j;
	static Queue<dust> queue = new LinkedList<dust>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();//각 변수들을 입력받는다.
		C = sc.nextInt();
		T = sc.nextInt();
		map = new int[R][C];
		mapc = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				mapc[i][j] = map[i][j];
				if(map[i][j]==-1) {
					clean_i = i;
					clean_j = j;// 2개의 공기청정기. 이 순서대로 입력받으면 i,j와 i-1,j가 공기청정기 좌표임.
				}
				if(map[i][j]>0) {
					queue.offer(new dust(i,j,map[i][j]));
					//초기 미세먼지 위치 저장.
				}
			}
		}
		bfs();

		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(mapc[i][j]<1) continue;
				sum = sum + mapc[i][j];
			}
		}
		System.out.println(sum);
	}
	private static void bfs() {
		
		int sec = 0;
		while(!queue.isEmpty()) {
			if ( sec ==T) return;
			
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				
				dust d = queue.poll();
				int count = 0;
				for (int j = 0; j < 4; j++) {
					
					int ny = d.i + dx[j];
					int nx = d.j + dy[j];
					
					if(ny<0||nx<0||ny>=R||nx>=C||mapc[ny][nx]==-1) continue;
					count++;
					mapc[ny][nx] = mapc[ny][nx] + d.size/5;
				}
				mapc[d.i][d.j] = mapc[d.i][d.j]- (d.size/5)*count;
				
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = mapc[i][j];
				}
			}
			//공기청정기 작동
			int ci = clean_i;
			int cj = clean_j;
			mapc[ci-1][cj+1] = 0;
			mapc[ci][cj+1] = 0;
			for (int i = 1; i < C-1-cj; i++) {
				mapc[ci-1][cj+1+i]	= map[ci-1][cj+i];
				mapc[ci][cj+1+i]	= map[ci][cj+i];
			}
			for (int i = 1; i <= C-1; i++) {
				mapc[0][C-1-i]	    = map[0][C-i];
				mapc[R-1][C-1-i]	= map[R-1][C-i];
			}
			for (int i = 1; i <= ci-1; i++) {
				mapc[ci-i-1][C-1]	= map[ci-i][C-1];
				
				if(mapc[i][0]==-1) continue;
				mapc[i][0]	= map[i-1][0];
			}
			
			for (int i = 1; i < R-ci; i++) {
				mapc[ci+i][C-1]	= map[ci+i-1][C-1];
				if(mapc[R-1-i][0]==-1) continue;
				mapc[R-1-i][0]	= map[R-i][0];
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(mapc[i][j]<4) continue;
					
					queue.offer(new dust(i,j,mapc[i][j]));
					
					//한 턴이 지난 후 미세먼지 위치를 다시 완탐에서 큐에 저장
					
				}
			}
			sec = sec + 1;
		}
	}
}