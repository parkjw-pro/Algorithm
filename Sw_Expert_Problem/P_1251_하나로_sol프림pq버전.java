package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_1251_하나로_sol프림pq버전 {
	
    static long getDistance(int x1, int x2, int y1, int y2) {
        return (long)((Math.pow(x1-x2,2) + Math.pow(y1-y2,2)));
    }
	
	private static int N;
	private static long arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= T; test++) {
        	N = Integer.parseInt(br.readLine());
        	
        	int x [] = new int[N];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
        	
        	int y [] = new int[N];
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
        	
        	arr = new long[N][N];
        	
        	for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = arr[j][i] = getDistance(x[i],x[j],y[i],y[j]);
				}
			}
        	
        	double E = Double.parseDouble(br.readLine());
        	System.out.println("#"+test+" "+Math.round(E*makeMST()));
        	
        	
        }

	}
	private static double makeMST() {
		long[] minEdge = new long[N];
		boolean visited[] = new boolean[N];
		
		long result = 0;// 최소 신장트리 비용
		int cnt = 0;

		Arrays.fill(minEdge,Long.MAX_VALUE );
		minEdge[0] = 0;
		
		
		PriorityQueue<Vertex> pqueue = new PriorityQueue<Vertex>();
		pqueue.offer(new Vertex(0,minEdge[0]));
		
		while(true) {
			
			//1단계 : 신장트리에 포함되지 않은 정점중  최소간선비용의 정점 선택
			Vertex minVertex = pqueue.poll();
			
			if(visited[minVertex.no]) continue;

			
			visited[minVertex.no] = true;
			result +=minVertex.cost;
			if(++cnt==N) break;
			
			//2단계 선택된 정점에서 신장트리에 포함되지 않은 다른 정점들로의 간선의 비용을 고려하여 minEdge 업데이트
			
		
			for (int i = 0; i < N; i++) {
				if(!visited[i] && arr[minVertex.no][i]>0&& minEdge[i]> arr[minVertex.no][i]) {
					minEdge[i] = arr[minVertex.no][i];
					pqueue.offer(new Vertex(i,minEdge[i]));
				}
			}
			
		}
		
		return result;
	}
	
	
	//pq를 사용하기 위한 객체 생성
	static class Vertex implements Comparable<Vertex>{
		
		int no;
		long cost;
		
		public Vertex(int no, long cost) {
			super();
			this.no = no;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Vertex o) {
			
			return Long.compare(this.cost, o.cost);
		}
		
		
		
	}

}
