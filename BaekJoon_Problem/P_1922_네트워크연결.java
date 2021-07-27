package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;



public class P_1922_네트워크연결 {
	
	static int N;
	static int M;
	static class Edge{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	static ArrayList<Edge> edgeList = new ArrayList<Edge>();	
	private static int[] parent;
	
	public static void make() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	public static int find(int a){
		if(parent[a] == a) return a;// 자신이 루트이면 그냥 자신의 번호 리턴
		return parent[a] = find(parent[a]);
	}
	
	public static boolean union(int a,int b){
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot){ // 두 노드의 root가 다르면 합침
			parent[bRoot] = aRoot;
			return true;
		}
		return false;
	}	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
 
		parent = new int[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(from, to, weight));
		}
		Collections.sort(edgeList, new Comparator<Edge>(){
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
        });
		make();
		int result = 0;
		int count = 0;
		
		for (int i = 0; i < edgeList.size(); i++) {
			
			//루트노드가 달라서 연결이 되었으면
			if(union(edgeList.get(i).start, edgeList.get(i).end)) {
				result += edgeList.get(i).weight;
				count++;
				if(count == N-1) break;
			}
		}
		System.out.println(result);
		
	}

}
