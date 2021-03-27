package com.ssafy;

import java.util.Scanner;

public class Problem_2231 {

	private static int answer= 0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for (int i = 1; i < N; i++) {
			find_constructure(i,i,N,i);
			if(answer!=0) {break;}
		}
		System.out.println(answer);
	}
	
	
	private static void find_constructure(int n, int sum, int num, int start) {
		
		int k = n%10;
		if(k==0&&n==0) {
			if(sum==num) {answer = start;}
			return ;
			}
		sum = sum + k;
		find_constructure((n-k)/10, sum, num, start );
	}
}