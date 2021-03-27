package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1780_종이의개수 {
	
	static int N,map[][];
	static int count[] = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			//in.readLine();
		}

		
		div(0,0,N);
		for (int i = 0; i < 3; i++) {
			System.out.println(count[i]);
		}

	}
	
	private static void div(int r, int c,int n) {
		if(n==0) return;
		
		
		boolean same = true;
		
		int k = map[r][c]+1;
		for (int i = r; i < r+n; i++) {
			if(!same) break;
			for (int j = c; j < c+n; j++) {
				if(k!=map[i][j]+1) {same = false; break;}
			}
		}
		if(same) {count[k]++; return;}
		n = n/3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				div(r+i*n, c+j*n, n); 
			}
		}
	}
}