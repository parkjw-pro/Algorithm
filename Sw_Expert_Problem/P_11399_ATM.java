package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class P_11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		
		int arr2[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j <= i; j++) {
				sum = sum+arr[j];
			}
			arr2[i] = sum;
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = answer+arr2[i];
		}
		System.out.println(answer);
		
	}

}
