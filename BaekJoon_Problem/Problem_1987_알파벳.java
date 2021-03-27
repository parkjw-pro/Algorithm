package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem_1987_알파벳 {
	
	static int N,M;
	static char map[][];
	static boolean vis[] = new boolean[26];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int max = 0;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];		

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		in.close();
		
		vis[map[0][0]-65] = true;
		dfs(0,0,1);
		System.out.println(max);
	}
	
	private static void dfs(int i, int j, int count) {
		max = Math.max(max, count);
		if(max==26) {
			return;
		}
		for (int k = 0; k < dx.length; k++) {
			
			int ny = i + dy[k];
			int nx = j + dx[k];
			if(ny>=0&&nx>=0&&ny<N&&nx<M&&!vis[map[ny][nx]-65]) {
				vis[map[ny][nx]-65]=true;
				dfs(ny,nx,count+1);
				vis[map[ny][nx]-65]=false;
			}
		}
		
	}
}