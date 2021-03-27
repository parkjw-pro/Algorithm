package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class P_14889_스타트와링크 {
	
	static int N,M,map[][];
	static int wsum;
	static int com[];
	static int min=10000000;
	static boolean vis[];

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = N/2	;
		map = new int[N][N];
		com = new int[M];
		vis= new boolean [N];
	//	wsum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt(); 
				//wsum = wsum+map[i][j];
			}
		}
		comb(0,0);
		System.out.println(min);
		sc.close();
	}
	private static void comb(int start, int cnt) {
		if(cnt==M) {
			int sum=0;
			int sum2=0;
			vis= new boolean [N];
			for (int i = 0; i < com.length; i++) {
				vis[com[i]] = true;
			}
			for (int i = 0; i < com.length; i++) {
				for (int j = 0; j < com.length; j++) {
					if(j==i) {continue;}
					sum = sum + map[com[i]][com[j]];
				}
			}
			for (int j2 = 0; j2 < N; j2++) {
				if(vis[j2]) {continue;}
				for (int i = 0; i < N; i++) {
					if(vis[i]) {continue;}
					sum2 = sum2 + map[j2][i];
				}
			}
			min=Math.min(min, Math.abs(sum-sum2));
			return;
		}
		for (int i = start ; i < N; i++) {
			com[cnt] = i;
			
			comb(i+1,cnt+1);
		}
	}
}