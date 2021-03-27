package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2178 {
	static int N,M;
	static char map[][];
	static boolean vis[][];
	static int count = 1;
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		vis = new boolean[N][M];
		sc.nextLine();
		
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		bfs(0,0);
		System.out.println(count);
	}
	
	public static void bfs(int a, int b) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int current_i = a;
		int current_j = b;
		queue.offer(current_i);
		queue.offer(current_j);
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int i1 = 0; i1 < size/2; i1++) {
				current_i =queue.poll();
				current_j =queue.poll();
				
				for (int i = 0; i < 4; i++) {
					
					int ny = current_i+dy[i];
					int nx = current_j+dx[i];
					
					if(ny>=0&&nx>=0&&ny<N&&nx<M&&map[ny][nx]=='1'&&!vis[ny][nx]) {
						vis[ny][nx]= true;
						if(ny==N-1&&nx==M-1) {count+=1;return;}
						queue.offer(ny);
						queue.offer(nx);
						
					}
				}
			}
			count++;
		}
	}
}