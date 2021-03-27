package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class P_1865_웜홀 {

	static class Edge {
		int from;
		int to;
		int time;
		public Edge(int from, int to, int time) {
			super();
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
	static int N, M, W;
	static ArrayList<Edge> edgelist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {

			N = sc.nextInt();
			M = sc.nextInt();
			W = sc.nextInt();
			int dist[] = new int[N + 1];
			edgelist = new ArrayList<Edge>();
			for (int i = 0; i < M; i++) {
				int from = sc.nextInt() ;
				int to = sc.nextInt() ;
				int weight = sc.nextInt();

				edgelist.add(new Edge(from, to, weight));
				edgelist.add(new Edge(to, from, weight));
			}
			for (int i = 0; i < W; i++) {
				int from = sc.nextInt() ;
				int to = sc.nextInt() ;
				int weight = sc.nextInt();
				edgelist.add(new Edge(from, to, -weight));
			}
			int INF = Integer.MAX_VALUE;
			//Arrays.fill(dist, INF);
			//Arrays.fill(dist, INF);
			boolean done = false;
			for (int k = 1; k < N+1; k++) {
				Arrays.fill(dist, INF);
				dist[k] = 0;

				for (int i = 1; i < N; i++) {
					for (int j = 0; j < edgelist.size(); j++) {
						Edge road = edgelist.get(j);

						if (dist[road.from] + road.time < dist[road.to]) {
							dist[road.to] = dist[road.from] + road.time;
						}
					}
				}
				
				for (int i = 0; i < edgelist.size(); i++) {
					Edge road = edgelist.get(i);
					if (dist[road.from] + road.time < dist[road.to]) {
						System.out.println("YES");
						done = true;
						break;
					}
				}
				if(done) break;
				
			}
			if(done) continue;
			System.out.println("NO");
		}
	}
}