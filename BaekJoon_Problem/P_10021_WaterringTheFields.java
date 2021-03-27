package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



public class P_10021_WaterringTheFields {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		
		
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

	static int V,C;
	static Edge[] pointList;
	static ArrayList<Edge> vaildpointList;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(in.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pointList = new Edge[V];
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pointList[i] = new Edge(x,y);
		}

		vaildpointList = new ArrayList();
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				int x1 = pointList[i].from;
				int y1 = pointList[i].to;
				int x2 = pointList[j].from;
				int y2 = pointList[j].to;
				
				int k = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
				if(k >=C) {
					vaildpointList.add(new Edge(i,j,k));
				}
			}
		}
		Collections.sort(vaildpointList);
		make();
		int cnt=0, result=0;
		for (Edge edge : vaildpointList) {
			if(union(edge.from , edge.to)) {//싸이클이 형성되지 않았다면
				++cnt;
				result += edge.weight;
				if(cnt == V-1) break;
			}
			
		}
		if(cnt == V-1) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
		
		
		
		
	}
	private static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);//받아온 대표자를 자신의 부모로 바꿔치기하고 리턴함.
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

}
