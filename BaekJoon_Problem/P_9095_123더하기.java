package com.ssafy;

import java.util.Scanner;

public class P_9095_123더하기 {
	
	static boolean check[];
	static int n,sum;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test = 0; test < T; test++) {
			check = new boolean[10000000];
			sum = 0;
			count = 0;
			n = sc.nextInt();
			
			per(0,0);
			System.out.println(count);
			
			
			
		}

	}
	private static void per(int s,int cnt) {

		if(s == n ) {
			//System.out.println(1);
			check[s] = true;
			count++;
			return;
		}
		if(cnt==n) {
			return;
		}
		for (int i = 1; i <= 3; i++) {
			per(s+ i, cnt+1);
		}
	}
}
