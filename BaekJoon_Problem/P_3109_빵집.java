package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_3109_빵집 {
	
	
	static int R,C,cnt;
	static int[] dy = {-1,0,1};
	static boolean visited[][];
	static char map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		

		
		map = new char[R][];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		makePipe();
		System.out.println(cnt);
		
		
	}
	
	private static void makePipe() {
		
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			start(i,0);
		}
	}
	
	private static boolean start(int r, int c) {
		
		if(c==C-1) {
			cnt = cnt + 1;
			return true;
		}
		int ny, nx = c+1;
		for (int i = 0; i < dy.length; i++) {
			ny = r + dy[i];
			
			if(ny<0||ny>=R||nx>=C||map[ny][nx]=='x'||visited[ny][nx]) continue;
			
			visited[ny][nx] = true;
			if(start(ny,nx)) return true;
		}
		return false;
	}
}