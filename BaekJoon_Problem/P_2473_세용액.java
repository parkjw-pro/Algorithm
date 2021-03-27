package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class P_2473_세용액 {

	static long arr[];
	static long[] answer = new long[3];
	static int N;
	static long inf = Long.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			shake(i);
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(answer[i] + " ");
		}

	}

	private static void shake(int n) {
		int a = n + 1;
		int b = arr.length - 1;

		while (a < b) {

			long sum = arr[a] + arr[b] + arr[n];

			if (Math.abs(sum) < inf) {

				inf = Math.abs(sum);
				answer[0] = arr[n];
				answer[1] = arr[a];
				answer[2] = arr[b];

			}

			if(sum > 0) {
				b = b - 1;
			}else {
				a = a + 1;
			}
		}
	}

}
