package com.ssafy;

import java.util.Scanner;

public class OneTwoThree_sum {
	
	static int total;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			total=0;
			int N = sc.nextInt();
			plus(N,0);
			System.out.println(total);
		}
	}
	
	private static void plus(int n, int sum_now) {
		
		if(sum_now>n) {return;}
		if(sum_now==n) {
			total++;
		}
		for (int i = 1; i < 4; i++) {
			plus(n, sum_now+i);
		}
	}
}