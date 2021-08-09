package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		//전부 원점에서 시작하는 사각형으로 표현 가능.
		// 합을 구하는데에 있어 식이 존재.
		// x,y 2 3  / 3,3  27
		int arr[][] = new int[N][N];
		int sum[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		int x1[] = new int[M];
		int x2[] = new int[M];
		int y1[] = new int[M];
		int y2[] = new int[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			x1[i] = Integer.parseInt(st.nextToken())-1; 
			y1[i] = Integer.parseInt(st.nextToken())-1; 
			x2[i] = Integer.parseInt(st.nextToken())-1; 
			y2[i] = Integer.parseInt(st.nextToken())-1; 
			
		}
		sum[0][0] = arr[0][0];
		for (int i = 1; i < N; i++) {
			sum[0][i] = sum[0][i-1] + arr[0][i];
		}
		
		for (int i = 1; i < N; i++) {
			//행의 합을 더할 변수 s
			int s = 0;
			for (int j = 0; j < N; j++) {
				s = s+ arr[i][j];
				sum[i][j] = sum[i-1][j] + s;
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(sum[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < M; i++) {
			
			int k=0;
			int k2=0;
			int k3 = 0;
			if(x1[i]>0) {
				k = sum[x1[i]-1][y2[i]];
			}
			if(y1[i]>0) {
				k2 = sum[x2[i]][y1[i]-1];
			}
			if(x1[i]>0&&y1[i]>0) {
				k3 = sum[x1[i]-1][y1[i]-1];
			}
			
			
			
			int answer = 
					sum[x2[i]][y2[i]] - 
					k -
					k2 +
					k3;
			
			System.out.println(answer);
		}
		
		
		

	
		
		
		
		
	}

}
