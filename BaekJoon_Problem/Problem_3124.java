package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Problem_3124 {
	
	
	static class Edge implements Comparable<Edge>{
		
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	
	static int N,V,E;
	static Edge[] edgelist;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		

		
		N = Integer.parseInt(st.nextToken());


		
		for (int T = 1; T <= N; T++) {
			st = new StringTokenizer(in.readLine().trim());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgelist = new Edge[E];
			parents = new int[V+1];
			
			int from,to,weight;
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(in.readLine().trim());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());
				
				edgelist[j] = new Edge(from, to, weight);
			}
			Arrays.sort(edgelist);
			
			int cnt = 0;
			long result = 0;
			make();
			for (Edge edge : edgelist) {
				
				if(union(edge.from, edge.to)) {
					++cnt;
					result += edge.weight;
					if(cnt==V-1) break;
			
				}
			}
			
			System.out.println("#"+T+" " +result);
		}

	}

	
	private static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
		
	private static boolean union(int a, int b) {

		int aroot = find(a);
		int broot = find(b);
		if(aroot!=broot) {
			parents[broot] = aroot;
			return true;
		}
		return false;
		
	}
}
