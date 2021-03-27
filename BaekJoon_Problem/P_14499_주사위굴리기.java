package com.ssafy;

import java.util.Scanner;

public class P_14499_주사위굴리기 {
	
	static int N,M,X,Y,K;
	static int arr[][];
	
	static int dice[] = new int [6];
	static int order[] ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][M];
		order = new int[K];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < K; i++) {
			order[i] = sc.nextInt();
		}
		go();
		sc.close();

	}
	private static void go() {
		
		int n = X;
		int m = Y;
		int d = 0;
		int[] dice2 = new int[6];
		for (int i = 0; i < K; i++) {
			d = 0;

			switch (order[i]) {
			case 1:
				if(m+1>=M) continue;
				m = m+1;
				d= d+2;
				
				if(arr[n][m]==0) {arr[n][m]=dice[d];}
				else {
					dice[d]=arr[n][m];
					arr[n][m] = 0;
				}
				for (int j = 0; j < 6; j++) {
					dice2[j] = dice[j];
				}
				dice[0] = dice2[2];
				dice[1] = dice2[1];
				dice[2] = dice2[5];
				dice[3] = dice2[0];
				dice[4] = dice2[4];
				dice[5] = dice2[3];

				break;
				
			case 2:
				if(m-1<0) continue;
				m = m-1;
				d= d+3;
				
				if(arr[n][m]==0) {arr[n][m]=dice[d];}
				else {
					dice[d]=arr[n][m];
					arr[n][m] = 0;
				}
				for (int j = 0; j < 6; j++) {
					dice2[j] = dice[j];
				}
				dice[0] = dice2[3];
				dice[1] = dice2[1];
				dice[2] = dice2[0];
				dice[3] = dice2[5];
				dice[4] = dice2[4];
				dice[5] = dice2[2];
				
				break;
				
			case 3:
				if(n-1<0) continue;
				n = n-1;
				d= d+1;
				if(arr[n][m]==0) {arr[n][m]=dice[d];}
				else {
					dice[d]=arr[n][m];
					arr[n][m] = 0;
				}
				for (int j = 0; j < 6; j++) {
					dice2[j] = dice[j];
				}
				dice[0] = dice2[1];
				dice[1] = dice2[5];
				dice[2] = dice2[2];
				dice[3] = dice2[3];
				dice[4] = dice2[0];
				dice[5] = dice2[4];
				
				break;
				
			case 4:
				if(n+1>=N) continue;
				n = n+1;
				d= d+4;
				if(arr[n][m]==0) {arr[n][m]=dice[d];}
				else {
					dice[d]=arr[n][m];
					arr[n][m] = 0;
				}
				for (int j = 0; j < 6; j++) {
					dice2[j] = dice[j];
				}
				
				dice[0] = dice2[4];
				dice[1] = dice2[0];
				dice[2] = dice2[2];
				dice[3] = dice2[3];
				dice[4] = dice2[5];
				dice[5] = dice2[1];
				
				break;

			default:
				break;
			}
			System.out.println(dice[5]);
		}
	}
}
