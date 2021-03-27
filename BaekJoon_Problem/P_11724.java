package com.ssafy;

import java.util.Scanner;

public class P_11724 {
	
	static int N,M;
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		parents = new int[N];
		M = sc.nextInt();
		make();
		
		for (int i = 0; i < M; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a-1,b-1);
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(parents[i]==i) {
				count++;
			}
		}
		
		System.out.println(count);

		

	}
	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
//		return find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}