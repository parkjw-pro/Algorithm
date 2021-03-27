package com.ssafy;

import java.util.Scanner;

public class P_2798_블랙잭 {
	
	static int N,M,arr[];
	static int arr2[] = new int[3];
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		black(0,0);
		System.out.println(max);
		sc.close();
	}
	private static void black(int start, int cnt) {
		
		if(cnt==3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum = sum + arr2[i];
			}
			if(sum<=M) {
				max = Math.max(max, sum);
				for (int i = 0; i < arr.length; i++) {
					
				}
			}
			return;
		}
		for (int i = start; i < arr.length; i++) {
			arr2[cnt] = arr[i];
			black(i+1,cnt+1);
		}
	}
}