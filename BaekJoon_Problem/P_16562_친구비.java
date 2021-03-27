package com.ssafy;

import java.util.Scanner;

public class P_16562_친구비 {
	
	static int N,M,k;
	static int fcost[];
	static int parents[];
	static int friendcost = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		k = sc.nextInt();
		fcost = new int[N];
		parents = new int[N];
		
		for (int i = 0; i < N; i++) {
			fcost[i] = sc.nextInt();
		}
		make();
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			if(a==b) continue;
			union(a,b);//친구니깐 연결해놓는다.
		}
		
		boolean friended[] = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			int cost = find(i);
			if(friended[cost]) continue;
			friendcost = friendcost+ fcost[cost];
			friended[cost] = true;
		}
		
		if(friendcost<=k) {
			System.out.println(friendcost);
		}else {
			System.out.println("Oh no");
		}
		
		
		

	}
	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return;
		
		if(fcost[aRoot]<=fcost[bRoot]) {
			parents[bRoot] = aRoot;
		}else {
			parents[aRoot] = bRoot;
		}
		return;
	}

}
