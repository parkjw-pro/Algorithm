package com.ssafy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P_4386_별자리만들기 {
	
	static class Star {
		
		double x;
		double y;
		int n;

		Star(double x, double y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return new Double(this.weight).compareTo(new Double(o.weight));
		}
	}
	static ArrayList<Edge> edgeList;
	static int[] parents;
	static int N;
	static double answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		edgeList = new ArrayList<>();
		N = sc.nextInt();
		Star[] Stars = new Star[N];
		parents = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			Stars[i] = new Star(a, b, i);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				//if(i==j) continue;
				double weight = Math.sqrt(Math.pow(Stars[i].x - Stars[j].x, 2) + Math.pow(Stars[i].y - Stars[j].y, 2));
				edgeList.add(new Edge(Stars[i].n, Stars[j].n, weight));
			
			}
		}
		Collections.sort(edgeList);
		make();
		
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			if (find(edge.from) != find(edge.to)) {
				answer += edge.weight;
				union(edge.from, edge.to);
			}
		}

		System.out.println( Double.parseDouble(String.format("%.2f",answer)));


	}
	private static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

}
