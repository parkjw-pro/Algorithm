package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class P_15591_MooTube {
	
	static int N,Q;
	static ArrayList<Node>[] list;
	

	static class Node{
		int next;
		int us;
		public Node(int next, int us) {
			super();
			this.next = next;
			this.us = us;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N  = sc.nextInt();
		Q = sc.nextInt();
		
		list = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < N-1; i++) {
			int start = sc.nextInt()-1;
			int end = sc.nextInt()-1;
			int usa = sc.nextInt();
			
			list[start].add(new Node(end, usa));
			list[end].add(new Node(start, usa));
		}
		
		for (int i = 0; i < Q; i++) {
			int K = sc.nextInt();
			int V = sc.nextInt()-1;
			System.out.println(bfs(V,K));
		}
		
	}
	private static int bfs(int start, int k) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		boolean[] visited = new boolean[N];
		visited[start] = true;
		int count = 0;

		while (q.size() > 0) {

			int cur = q.poll();
			count++;

			for (Node n: list[cur]) {
				if (!visited[n.next] && n.us >= k) {
					q.offer(n.next);
					visited[n.next] = true;
				}
			}
		}
		return count-1;
	}
}
