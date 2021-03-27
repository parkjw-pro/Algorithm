package com.ssafy;

import java.util.Scanner;

public class P_2668_숫자고르기 {
	
	static int N;
	static int arr[];
	static boolean vis[];
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	
		N = sc.nextInt();
		
		arr = new int[N];
		vis = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt()-1;
		}
		for (int i = 0; i < N; i++) {
			if(vis[i]) continue;
			vis[i] = true;
			if(!search(i,arr[i])) {
				vis[i] = false;
			}else {
				vis[i] = true;
			}
		}
		for (int i = 0; i < N; i++) {
			if(vis[i]) answer++;
		}
		System.out.println(answer);
		for (int i = 0; i < N; i++) {
			if(vis[i]) System.out.println(i+1);
		}

	}
	private static boolean search(int n, int m ) {
		if(arr[m] == n) {
			vis[m] = true;
			return true;
		}
		if(vis[m]) return false;
		
		vis[m] = true;
		if(!search(n,m)) {
			vis[m] = false;
			return false;
		}else {
			return true;
		}
	}

}
