package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P_11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		
		int arr[] = new int[N];
		int sum[] = new int[N];
		int a[] = new int[M];
		int b[] = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken())-1; 
			b[i] = Integer.parseInt(st.nextToken())-1; 

		}
		sum[0] = arr[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		
		
		
		for (int i = 0; i < b.length; i++) {
			if(a[i]==0) {
				System.out.println(sum[b[i]]);
			}else {
				System.out.println(sum[b[i]]-sum[a[i]-1]);
			}
		}

		



		
	}

}
