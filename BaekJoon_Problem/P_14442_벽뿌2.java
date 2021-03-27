package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_14442_벽뿌2 {
	
	static class human{
		int i;
		int j;
		int avail;
		int count;
		public human(int i, int j, int avail, int count) {
			super();
			this.i = i;
			this.j = j;
			this.avail = avail;
			this.count = count;
		}
	}
	
	static int N,M,K;
	static char map[][];
	static boolean vis[][][];
	static int answer=-1;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][];
		vis = new boolean[K+1][N][M];
		
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			map[i] = s.toCharArray();
			
		}
		bfs();
		System.out.println(answer);
	}
	
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	
	private static void bfs() {
		Queue<human> queue = new LinkedList<human>();
		
		queue.offer(new human(0,0,K,1));
		vis[K][0][0] = true;
		
		while(!queue.isEmpty()) {
			
			human h = queue.poll();
			
			if(h.i==N-1&&h.j==M-1) {
				answer = h.count;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				
				int ny = h.i+dy[i];
				int nx = h.j+dx[i];
				
				if(ny<0||nx<0||ny>=N||nx>=M||vis[h.avail][ny][nx]) continue;
				
				if(map[ny][nx]=='1'&&h.avail>0&&!vis[h.avail-1][ny][nx]) {
					queue.offer(new human(ny,nx,h.avail-1,h.count+1));
					vis[h.avail-1][ny][nx] =true;
					continue;
				}
				if(map[ny][nx]=='0') {
				queue.offer(new human(ny,nx,h.avail,h.count+1));
				vis[h.avail][ny][nx] = true;
				}
			}
		}
	}
}