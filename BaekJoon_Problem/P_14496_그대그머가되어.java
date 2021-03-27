package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 더 줄이기
public class P_14496_그대그머가되어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		
		st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		

		final int INFINITY = Integer.MAX_VALUE;

		ArrayList<Integer> adj[] = new ArrayList[V];

		for (int i = 0; i < V; i++) { // V+1 개
			adj[i] = new ArrayList<Integer>();
		}

		int distance[] = new int[V];
		boolean visited[] = new boolean[V];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(st.nextToken()); // 정점 번호 1 based
			int v2 = Integer.parseInt(st.nextToken()); // 정점 번호 1 based
			

			adj[v1-1].add(v2-1); // adj.add(new Edge(v2, cost)); ( X )
			adj[v2-1].add(v1-1);
		}

		Arrays.fill(distance, INFINITY);
		distance[start] = 0;

		int result = 0;
		int min = 0, current = 0;

		for (int i = 0; i < V; i++) {

			min = INFINITY;
			// 1단계 : 방문하지 않은 정점들 중에 출발지에서 자신까지 오는 비용이 최단인 정점을 경유지로 선택

			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			//System.out.println(min);
			visited[current] = true;
			result = result + min;
			//if(current==end) break;
			
			// 2단계 : 선택된 current 정점을 경유지로해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 update

			for (Integer a : adj[current]) {
				if (!visited[a] && distance[a] > min + 1) {
					distance[a] = min + 1;
				}
			}
		}
		

		if(distance[end]==INFINITY) {
			System.out.println(-1);
		}else {
			
			System.out.println(distance[end]);
		}


		
		

	}
}
