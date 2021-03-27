package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class P_11779_최소비용2 {
 
	static class Edge{
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		int E = Integer.parseInt(in.readLine());
		final int INFINITY = Integer.MAX_VALUE;
		
		ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int adj2[] = new int[V];
		
        for (int i = 0; i <= V; i++) { // V+1 개
            adj.add(new ArrayList<Edge>());
        }
		
		int distance[] = new int [V];
		boolean visited[] = new boolean[V];
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
            int v1 = Integer.parseInt(st.nextToken());     // 정점 번호 1 based
            int v2 = Integer.parseInt(st.nextToken());    // 정점 번호 1 based
            int cost = Integer.parseInt(st.nextToken());
  
            adj.get(v1-1).add(new Edge(v2-1, cost));    // adj.add(new Edge(v2, cost));  ( X )
           
		}
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;

		int cnt = 0;
		int a = 0;
	
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;

		
		int min=0, current = 0;
		
		for (int i = 0; i < V; i++) {
			
			min = INFINITY;
			// 1단계 : 방문하지 않은 정점들 중에 출발지에서 자신까지 오는 비용이 최단인 정점을 경유지로 선택
		
			for (int j = 0; j < V; j++) {
				if(!visited[j]&& min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			//System.out.println(current);
			if(!visited[current]) {
				visited[current] = true;
				
				
			}

			//System.out.println(current+" "+ end);
			if(current==end) break;
			
			
			for (Edge e : adj.get(current)) {
				
				if(!visited[e.vertex]&& distance[e.vertex] > min + e.cost) {
					distance[e.vertex] = min + e.cost;
					adj2[e.vertex] = current;
				}
			}
		}
		System.out.println(distance[end]);
		
		
		  //역추적
		//내가 도착 지점까지 거친 정점을 출력.
        while(end!=start){
            ret.add(end);
            end = adj2[end];
        }
        
      
        ret.add(start);
        System.out.println(ret.size());
        Collections.reverse(ret);
        for(int i=0;i<ret.size();i++)
            System.out.print(ret.get(i)+1+" ");
		
//		System.out.println(adj2.size()+1);

		

	}
}
