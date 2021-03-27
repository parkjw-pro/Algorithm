package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2630_색종이만들기 {
	
	static int N,map[][];
	static int count[] = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map  = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		int k = N;
		div(0,0,k);
		for (int i = 0; i < 2; i++) {
			System.out.println(count[i]);
		}

	}
	
	private static void div(int r, int c,int n) {
		if(n==0) return;
		
		
		boolean same = true;
		
		int k = map[r][c];
		for (int i = r; i < r+n; i++) {
			if(!same) break;
			for (int j = c; j < c+n; j++) {
				if(k!=map[i][j]) {same = false; break;}
			}
		}
		if(same) {count[k]++; return;}
		n = n/2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				div(r+i*n, c+j*n, n); 
			}
		}
	}
}