package com.ssafy;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_7576 {
	
	static int box[][] ;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static int N;
	static int M;
	static int lastday;
	static int start[];
	static Queue<tomato>  queue= new LinkedList<tomato>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		M = sc.nextInt();
		N = sc.nextInt();
		box = new int[N][M];
		int answer=0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j]==1) {
					queue.offer(new tomato(i, j));
				}
			}
			
		}
		
		
		bfs();
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j]==0) {
				answer = -1;}
			}
		}
		if(answer == -1) {
		
			System.out.println(answer);

		}else {
			System.out.println(lastday);
		}
	}
	
//	private static void dfs(int si, int sj, int day) {
//
//		
//
//		for (int i = 0; i < 4; i++) {
//			int ny = si + dy[i];
//			int nx = sj + dx[i];
//			
//			if(ny>=0&&nx>=0&&ny<N&&nx<M&&box[ny][nx]==0) {
//				
//				box[ny][nx] = 1;
//
//				dfs(ny,nx, day+1);
//			}
//			
//		}
//		if(day>lastday) {
//			lastday = day-1;
//		}
//		
//		return;
//	}

	private static void bfs() {
		
		int date=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j]==1) {
					queue.offer(new tomato(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
		
			int size = queue.size();
			while(--size>=0) {
				tomato t = queue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = t.N_number + dy[i];
					int nx =t.M_number + dx[i];
					
					if(ny>=0&&nx>=0&&ny<N&&nx<M&&box[ny][nx]==0) {
						box[ny][nx] = 1;
						queue.offer(new tomato(ny,nx));
					}		
				}
			}
			date++;
		}
		lastday=date-1;
	}
    static class tomato{
    	int N_number;
    	int M_number;
        public tomato(int N_number, int M_number){
            this.N_number = N_number;
            this.M_number = M_number;
        }
    }
}
