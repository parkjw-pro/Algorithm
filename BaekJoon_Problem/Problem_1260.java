package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1260 {
	
	static int N,M,V;
	static ArrayList<Integer>[] adjList;
	static boolean vis[];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt()-1;
		adjList = new ArrayList[N];
		vis = new boolean[N];

		for (int i = 0; i < N; i++) {
			
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i <M; i++) {
			
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from-1].add(to-1);
			adjList[to-1].add(from-1);
		}	
		
		for (int i = 0; i < N; i++) {
			
			Collections.sort(adjList[i], new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {

					return o1-o2;
				}
			});
		}
		dfs(V);
		System.out.println();
		vis = new boolean[N];
		bfs(V);
	}
	
	private static void dfs(int i) {
		
		vis[i] = true;
		System.out.print(i+1+" ");
		for (int temp  : adjList[i]) {
			if(!vis[temp]) {
				dfs(temp);
			}
		}
	}
	
	private static void bfs(int i) {
		Queue<Integer> queue = new 	LinkedList<Integer>();
		
		int current = i;
		vis[current] = true;
		queue.offer(current);
		
		while(!queue.isEmpty()) {
			
			current = queue.poll();
			System.out.print(current+1+" ");
			for (int temp : adjList[current]) {
				
				if(!vis[temp]) {
					
					vis[temp] = true;
					queue.offer(temp);
				}
			}
		}
	}
}