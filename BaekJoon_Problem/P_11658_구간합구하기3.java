package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11658_구간합구하기3 {

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
		int x1 =0;
		int x2 =0;
		int y1 =0;
		int y2 =0;
//		ArrayList<Integer> x2 = new ArrayList<Integer>();
//		ArrayList<Integer> y1 = new ArrayList<Integer>();
//		ArrayList<Integer> y2 = new ArrayList<Integer>();
		
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==0) {
				arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
				continue;
			}else {
				x1 = Integer.parseInt(st.nextToken())-1; 
				y1 = Integer.parseInt(st.nextToken())-1; 
				x2 = Integer.parseInt(st.nextToken())-1; 
				y2 = Integer.parseInt(st.nextToken())-1; 
//				y1.add(Integer.parseInt(st.nextToken())-1); 
//				x2.add(Integer.parseInt(st.nextToken())-1); 
//				y2.add(Integer.parseInt(st.nextToken())-1); 
				
				
				sum[0][0] = arr[0][0];
				for (int i = 1; i < N; i++) {
					sum[0][i] = sum[0][i-1] + arr[0][i];
				}
				
				//여기가 문제다.....
				for (int i = 1; i < N; i++) {
					//행의 합을 더할 변수 s
					int s = 0;
					for (int j = 0; j < N; j++) {
						s = s+ arr[i][j];
						sum[i][j] = sum[i-1][j] + s;
					}
				}
				
				int k1=0;
				int k2=0;
				int k3 = 0;
				if(x1>0) {
					k1 = sum[x1-1][y2];
				}
				if(y1>0) {
					k2 = sum[x2][y1-1];
				}
				if(x1>0&&y1>0) {
					k3 = sum[x1-1][y1-1];
				}
				
				
				
				int answer = 
						sum[x2][y2] - 
						k1 -
						k2 +
						k3;
				
				System.out.println(answer);
			}

			
		}
	}
}
