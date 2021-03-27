package com.ssafy;

import java.util.Scanner;

public class P_2117_홈방범서비스 {
	
	static int N,M,map[][];
	static int answer ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			answer = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = sc.nextInt();
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					go(j,j2);
				}
			}
			System.out.println("#"+i+" "+answer);
			
		}

	}
	private static void go(int r, int c) {
		

		for (int k = 1; k <= N+1; k++) {
			int fee = 0;
			int homecount = 0;
			int Kcount =  (k * k) + (k - 1) * (k - 1);
			for (int i = r-k; i <= r+k; i++) {
				for (int j = c-k; j <= c+k; j++) {
					if(i>=0&&j>=0&&i<N&&j<N&&(Math.abs(i-r)+Math.abs(j-c))<k) {
						if(map[i][j]==1) {
							fee = fee+M;
							homecount ++;
						}
					}
				}
			}
			if(Kcount<=fee) {
				answer = Math.max(answer, homecount);
			}
		}
	}

}
