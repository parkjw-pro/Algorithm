package com.ssafy;

import java.util.Scanner;

public class P_11048_이동하기Dp {
	static int N,M;
	static int arr[][];

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] =sc.nextInt();
			}
		}
		
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
            	
//            	int left = arr[i][j-1];
//            	int up = arr[i-1][j];
//            	
//               arr[i][j] = arr[i][j] +  Math.max(left, up);
                arr[i][j] += Math.max(arr[i][j-1],arr[i-1][j]);
            }
        }
        
        System.out.println(arr[N][M]);
		
	}

}
