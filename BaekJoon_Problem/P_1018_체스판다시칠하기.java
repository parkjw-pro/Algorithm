package com.ssafy;

import java.util.Scanner;

public class P_1018_체스판다시칠하기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		char arr[][] = new char[N][M];
		sc.nextLine();

		for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			arr[i] = s.toCharArray();
		}
		int answer = Integer.MAX_VALUE;

		// 시작점이 될수 있는 모든 점에 대해 계산
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {

				// 시작점을 W 또는 B일때 둘다 계산
				// 8*8 브루트포스
				int sum = 0;
				int sum2 = 0;
				for (int k = 0; k < 8; k++) {
					for (int k2 = 0; k2 < 8; k2++) {
						if ((k + k2) % 2 == 0) {
							if (arr[i + k][j + k2] == 'B') {
								sum++;
							} else {
								sum2++;
							}
						}else {
							if (arr[i + k][j + k2] == 'W') {
								sum++;
							} else {
								sum2++;
							}
						}
					}
				}
				sum = Math.min(sum, sum2);
				answer = Math.min(answer, sum);
			}
		}
		System.out.println(answer);
	}
}