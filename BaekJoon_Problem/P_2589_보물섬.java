package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_2589_보물섬 {
	
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int N,M;
	static char map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][];
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			map[i] = s.toCharArray();
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!='L') continue;
				int dis = bfs(i,j);
				if(result<dis) result = dis;
			}
		}
		System.out.println(result);
	}
	private static int bfs(int r,int c) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(r);
		queue.add(c);
		queue.add(0);
		int max = 0;
		
		boolean vis[][] = new boolean[N][M]; 
		vis[r][c] = true;

		while(!queue.isEmpty()) {
			
			int ci = queue.poll();
			int cj = queue.poll();
			int count = queue.poll();

			if(max<count) max = count;
			
			for (int i = 0; i < 4; i++) {
				int ny = ci+dy[i];
				int nx = cj+dx[i];

				if(ny<0||nx<0||ny>=N||nx>=M||map[ny][nx]!='L'||vis[ny][nx]) continue;
				
				vis[ny][nx] = true;

				queue.add(ny);
				queue.add(nx);
				queue.add(count+1);
			}
			
		}
		return max;
		
	}

}
