package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_10816_숫자카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int vis[] = new int[20000001];
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());

			vis[a + 10000000]++;

		}
		int M = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());

					sb.append(vis[n+10000000] + " ");

		}

		System.out.println(sb.toString());

	}
}
