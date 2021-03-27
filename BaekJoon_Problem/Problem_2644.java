package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2644 {
	
	static int N,A,B,m;
	static ArrayList<Integer> adj[];
	static boolean vis[];
	static int count = 0;;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		m = sc.nextInt();
		vis = new boolean[N];
		adj = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adj[from-1].add(to-1);
			adj[to-1].add(from-1);
		}
		dfs(A-1,count);
		if(count==0) {System.out.println(-1);}
	}
	
	public static void dfs(int a, int c) {
		
		vis[a] = true;
		if(a==B-1) {
			System.out.println(c);
			count = c;
			return;
		}
 		for (Integer num : adj[a]) {
 			
 			if(!vis[num]) {
 				dfs(num,c+1);
 			}
		}
	}
}