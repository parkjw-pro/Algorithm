package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라(dijkstra) 알고리즘 적용
// - 비용 없음
// 

// 시작부터 정점까지의 최소 비용 ( 최단 거리 ) 즉, 총비용을 관리하는  배열 vCost * 목표 *
// vCost 배열을 초기값은 무한대 값 으로, 시작 정점 값은 0 으로 설정하고 완성해 가는 과정, 모든 정점을 다 가지 못할 수도 있다. 
// 비용이 낮은 (거리가 가까운) 간선 선택을 위한 우선순위 큐

// 현재 정점에서 인접한 정점과의 비용을 검토하면서, 현재 정점을 통해서 인접한 정점으로 이동하는 것이 이전에 파악된  인접한 정점의 총 비용보다 낮으면
// 인접한 정점의 총 비용( vCost 배열 )을 갱신 해 주는 게 특징
public class P_1753_최단경로_pq {

static class Edge{
    int vertex;
    int cost;
    
    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
    
    ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
    
    for (int i = 0; i <= V; i++) { // V+1 개
        adj.add(new ArrayList<Edge>());
    }
    
    for (int i = 0; i < E; i++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        adj.get(v1).add(new Edge(v2, c)); // 유향이므로 1개만
    }
    
    // 시작 위치부터 각 정점까지의 총비용의 초기값을 MAX 로 설정
    int[] vCost = new int[V+1];
    Arrays.fill(vCost, Integer.MAX_VALUE);
    
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>( (e1, e2) -> e1.cost - e2.cost );
    boolean[] visit = new boolean[V+1];

    pq.add(new Edge(K, 0)); // 번호가 K 인 정점에서 시작, pq 에 한 개만 add
    
    vCost[K] = 0;
    
    while( ! pq.isEmpty() ) {
        Edge e = pq.poll();

        if( visit[e.vertex] ) continue;
        visit[e.vertex] = true;

        // 현재 정점에서 선택 가능한 다음 정점(이웃한 정점) (ne)들을 살펴보면서
        // 현재 파악된 다음 정점 (ne) 의 총비용보다 현재 정점을 거쳐가면 비용이 낮아지면 <-- 초기값 Integer.MAX_VALUE
        // 1. 그 정점(ne) 의 총비용 값을 갱신
        // 2. queue 에 넣는다.
        
        for( Edge ne : adj.get(e.vertex) ) {
            // vCost[ne.vertex] : 선택 가능한 다음 정점(이웃한 정점) 의 현재 총 비용 ( 무한대이거나 어떤 정수 값 )
            // vCost[e.vertex] + ne.cost : 새로 가려는 정점을 현재 간선을 선택해서 가는 비용 = 현재 정점의 총 비용 + 이 정점부터의 비용 
            if ( vCost[ne.vertex] > vCost[e.vertex] + ne.cost ) {
                // 총 비용 갱신
                vCost[ne.vertex] = vCost[e.vertex] + ne.cost;
                
                // pq 넣는 방법 2가지
                // #1 비용이 갱신되면 모두 넣고 pq 에서 visit 로 거른다.
                pq.add(new Edge(ne.vertex, vCost[ne.vertex]));
                
                // #2 비용이 갱신되더라고 이미 방문한 곳은 skip Integer.MAX_VALUE 이었던 것만 pq 에 넣는다.
//                    if( ! visit[ne.vertex] ) {
//                        pq.add(new Edge(ne.vertex, vCost[ne.vertex]));
//                    }
                }
            }
        }

        // 출력 부분
        for (int i = 1; i <= V; i++) {
            if ( ! visit[i] )
                System.out.println("INF");
            else {
                System.out.println(vCost[i]);
            }
        }
    }
}