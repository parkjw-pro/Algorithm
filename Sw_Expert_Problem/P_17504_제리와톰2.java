package com.ssafy;

import java.util.Scanner;

public class P_17504_제리와톰2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long arr[] = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		long head = 1;
		long body = arr[N-1];
		long temp = 0;
		
		for (int i = N-2; i >= 0; i--) {
			
			head = arr[i]*body+head;
			temp = body;
			body = head;
			head = temp;
			
			
		}
		
		System.out.println((body-head)+" "+body);

	}

}
