package com.ssafy;

import java.util.*;
import java.io.*;

public class Promblem_1238_sol {
		
	static int[][] edges;
	static int[] visit;
	static int N, S;
	static Queue<Node> queue;
	static ArrayList <Node> result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			
			StringTokenizer tk = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(tk.nextToken());
			S = Integer.parseInt(tk.nextToken());
			
			edges = new int[N+1][N+1];
			visit = new int[N+1];
			
			queue = new LinkedList<>();
			result = new ArrayList<>();
			int maxDepth = 1;
			
			tk = new StringTokenizer(br.readLine());
			while(tk.hasMoreTokens()) {
				int from = Integer.parseInt(tk.nextToken());
				int to = Integer.parseInt(tk.nextToken());
				edges[from][to] = 1;
			}

			queue.add(new Node(1, S));
			result.add(new Node(1, S));
			visit[S] = 1;

			while(!queue.isEmpty()) {
				
				Node node = queue.poll();
				
				int v = node.v;
				int d = node.d;
				
				for(int i = 0; i < N; i++) {
					if(edges[v][i] == 1 && visit[i] == 0) {
						visit[i] = 1;
						result.add(new Node(d + 1, i));
						queue.add(new Node(d + 1, i));
					}
				}
				maxDepth = Math.max(maxDepth, d);
			}
			
			
			int maxValue = 1;
			for(int i = 0; i < result.size(); i++) {
				if(result.get(i).d == maxDepth) {
					maxValue = Math.max(maxValue, result.get(i).v);
				}
			}
			System.out.println("#" + t + " " + maxValue);
		}
	}
	
	static class Node{
		int d;
		int v;
		Node(int d, int v){
			this.d = d;
			this.v = v;
		}
	}
}