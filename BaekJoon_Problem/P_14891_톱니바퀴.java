package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_14891_톱니바퀴 {
	
	static char arr[][];
	static int dir;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		 arr = new char[4][];
		
		for (int i = 0; i < 4; i++) {
			String s = in.readLine();
			arr[i] = s.toCharArray();
		}
		
		int N = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			
//			System.out.println("num "+num);
			switch (num) {
			case 1:
				if(arr[0][2]==arr[1][6]) {
					ro(0,dir);
					break;
				}
				
				if(arr[1][2]==arr[2][6]) {
					ro(0,dir);
					ro(1,-dir);
					break;
				}
				
				if(arr[2][2]==arr[3][6]) {
					ro(0,dir);
					ro(1,-dir);
					ro(2,dir);
					break;
				}
				ro(0,dir);
				ro(1,-dir);
				ro(2,dir);
				ro(3,-dir);
				break;
			case 2:
				
				if(arr[1][6]!=arr[0][2]) {
					ro(0,-dir);
				}
				if(arr[1][2]==arr[2][6]) {
					ro(1,dir);
					break;
				}
				if(arr[2][2]==arr[3][6]) {
					ro(1,dir);
					ro(2,-dir);
					break;
				}
				ro(1,dir);
				ro(2,-dir);
				ro(3,dir);
				break;
			case 3:
				
				if(arr[2][2]!=arr[3][6]) {
					ro(3,-dir);
				}
				if(arr[2][6]==arr[1][2]) {
					ro(2,dir);
					break;
				}
				if(arr[1][6]==arr[0][2]) {
					ro(1,-dir);
					ro(2,dir);
					break;
				}
				ro(0,dir);
				ro(1,-dir);
				ro(2,dir);
				break;
			case 4:
				if(arr[3][6]==arr[2][2]) {
					ro(3,dir);
					break;
				}
				if(arr[2][6]==arr[1][2]) {
					ro(3,dir);
					ro(2,-dir);
					break;
				}
				if(arr[1][6]==arr[0][2]) {
					ro(1,dir);
					ro(3,dir);
					ro(2,-dir);
					break;
				}
				ro(1,dir);
				ro(3,dir);
				ro(2,-dir);
				ro(0,-dir);
				break;

			default:
				break;
			}

			
		}
		int sum = 0;
		int k = 1;
		for (int j = 0; j < 4; j++) {
//			System.out.println("sum "+sum);
//			System.out.println("k "+k);
			sum = sum+ (arr[j][0]-48)*k;
			k = k*2;

		}
		System.out.println(sum);
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 8; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//			
//		}
		

	}
	//a = 돌리는 톱니 d = 방향
	private static void ro(int a, int d) {

		
		char arr2[][] = new char[4][8];
		
		for (int i = 0; i < 8; i++) {
			arr2[a][i] = arr[a][i];
		}
		
		char temp = arr2[a][7];
		char temp2 = arr2[a][0];
		for (int j = 0; j < 7; j++) {
			if(d==1) {
				arr[a][j+1] = arr2[a][j];
			}
			if(d==-1){
				arr[a][j] = arr2[a][j+1];
			}
		}
		for (int j = 0; j < 8; j++) {
		}
		if(d==1) {
			arr[a][0] = temp;
		}
		if(d==-1){
			arr[a][7] = temp2;
			
		}
	}
}
