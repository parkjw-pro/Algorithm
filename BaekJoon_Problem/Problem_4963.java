package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Problem_4963 {
	
	static int M,N, map[][];
	static boolean mapc[][];
	static int dy[] = {-1,1,0,0,1,1,-1,-1};
	static int dx[] = {0,0,-1,1,1,-1,1,-1};
	static boolean vis[][];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			M = sc.nextInt();
			N = sc.nextInt();
			if(M==0&&N==0) {break;}
			map = new int[N][M];
			mapc= new boolean[N][M];
			vis = new boolean[N][M];
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1&& !vis[i][j]) {count++ ; bfs(i,j);}
				}
			}
			System.out.println(count);
		}
	}

	private static void bfs(int n, int m) {
		Queue<island>  queue= new LinkedList<island>();
		
		vis[n][m] = true;
		queue.offer(new island(n,m));
		
		while(!queue.isEmpty()) {
		
			island is = queue.poll();
		
			for (int i = 0; i < 8; i++) {
				
				int ny = is.N_number + dy[i];
				int nx =is.M_number + dx[i];
				
				if(ny>=0&&nx>=0&&ny<N&&nx<M&&!vis[ny][nx]&&map[ny][nx]==1) {
					vis[ny][nx] = true;
					queue.offer(new island(ny,nx));
				}
			}
		}
	}
    static class island{
    	int N_number;
    	int M_number;
        public  island(int N_number, int M_number){
            this.N_number = N_number;
            this.M_number = M_number;
        }
    }
}