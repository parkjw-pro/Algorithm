package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_1600_말이되고픈원숭이 {

	static class monkey {
		int i;
		int j;
		int avail;
		int count;

		public monkey(int i, int j, int avail, int count) {
			super();
			this.i = i;
			this.j = j;
			this.avail = avail;
			this.count = count;
		}
	}
	static int K, N, M;
	static int map[][];
	static int min = 10000;
	static boolean vis[][][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		M = sc.nextInt();
		N = sc.nextInt();
		vis = new boolean[N][M][K+1];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs();
		if (min == 10000) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };
	static int dy2[] = { -2, -1, -2, -1, 1, 2, 2, 1 };
	static int dx2[] = { -1, -2, 1, 2, 2, 1, -1, -2 };

	private static void bfs() {
		Queue<monkey> queue = new LinkedList<monkey>();

		queue.offer(new monkey(0, 0, K, 0));
		vis[0][0][K] = true;

		while (!queue.isEmpty()) {
			
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				
				monkey m = queue.poll();

				if (m.i == N-1 && m.j == M-1) {

					min = m.count;
					queue.clear();
					return;
				}
				for (int i = 0; i < 4; i++) {

					int ny = m.i + dy[i];
					int nx = m.j + dx[i];

					if (ny<0 ||nx<0 ||ny>=N ||nx>= M ||map[ny][nx] == 1||vis[ny][nx][m.avail]) continue;

					vis[ny][nx][m.avail] = true;
					queue.offer(new monkey(ny, nx, m.avail, m.count + 1));
				}
				if (m.avail == 0) continue;// 해당 원숭이가 더이상 말처럼 뛸수 없으면 continue;
				
				for (int i = 0; i < 8; i++) {

					int ny = m.i + dy2[i];
					int nx = m.j + dx2[i];
					
					if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 1 || vis[ny][nx][m.avail-1]) continue;
					

					vis[ny][nx][m.avail - 1] = true;
					queue.offer(new monkey(ny, nx, m.avail - 1, m.count + 1));
					
				}
			}
		}
	}
}