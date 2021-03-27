//package com.ssafy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//
//public class P_11404_플로이드 {
// 
//	static class Edge{
//        int vertex;
//        int cost;
//
//        public Edge(int vertex, int cost) {
//            this.vertex = vertex;
//            this.cost = cost;
//        }
//    }
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int V = Integer.parseInt(in.readLine());
//		int E = Integer.parseInt(in.readLine());
//		final int INFINITY = Integer.MAX_VALUE;
//		
//		ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();            
//		
//        for (int i = 0; i <= V; i++) { // V+1 개
//            adj.add(new ArrayList<Edge>());
//        }
//		
//		int distance[] = new int [V];
//		boolean visited[] = new boolean[V];
//		
//		for (int i = 0; i < E; i++) {
//			StringTokenizer st = new StringTokenizer(in.readLine());
//            int v1 = Integer.parseInt(st.nextToken());     // 정점 번호 1 based
//            int v2 = Integer.parseInt(st.nextToken());    // 정점 번호 1 based
//            int cost = Integer.parseInt(st.nextToken());
//  
//            adj.get(v1-1).add(new Edge(v2-1, cost));    // adj.add(new Edge(v2, cost));  ( X )
//           
//		}
//		
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		int start = Integer.parseInt(st.nextToken())-1;
//		int end = Integer.parseInt(st.nextToken())-1;
//
//		int cnt = 0;
//		
//	
//		Arrays.fill(distance, INFINITY);
//		distance[start] = 0;
//
//		
//		int min=0, current = 0;
//		
//		for (int i = 0; i < V; i++) {
//			
//			min = INFINITY;
//			// 1단계 : 방문하지 않은 정점들 중에 출발지에서 자신까지 오는 비용이 최단인 정점을 경유지로 선택
//		
//			for (int j = 0; j < V; j++) {
//				if(!visited[j]&& min > distance[j]) {
//					min = distance[j];
//					current = j;
//				}
//			}
//			
//			visited[current] = true;
//			//System.out.println(current+" "+ end);
//			if(current==end) break;
//			
//			// 2단계 : 선택된 current 정점을 경유지로해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 update
//			cnt++;
//			for (Edge e : adj.get(current)) {
//				if(!visited[e.vertex]&& distance[e.vertex] > min + e.cost) {
//					distance[e.vertex] = min + e.cost;
//				}
//			}
//		}
//		System.out.println(distance[end]);
//	}
//}
