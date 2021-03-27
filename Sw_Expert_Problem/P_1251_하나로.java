package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 프림 알고리즘
// n크기의 배열을 하나 만든다 -> 이 배열은 특정 점점에서 갈 수있는 길의 길이를 저장한다.
// 초기 시작값을 아무거나 정한다 -> 프림알고리즘은 어디부터 시작되는것에 대한 의미가 없다.
// 거기의 min배열을 0으로 넣고 시작한다.

// 점점을 지나가면 visit처리를하고, 그 이후 지나가면서 min배열을 계속 업데이트 해주면서 최적의 해를 구한다.


public class P_1251_하나로 {
	
    static long getDistance(int x1, int x2, int y1, int y2) {
        return (long)((Math.pow(x1-x2,2) + Math.pow(y1-y2,2)));
    }
	
	static class island{
		int i;
		int j;
		
		public island(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= T; test++) {
        	
            int cnt = Integer.parseInt(br.readLine()); // 정점 갯수
   //         System.out.println(cnt);
            island arr[] = new island[cnt];
            boolean[] visited = new boolean[cnt]; // 정점 방문 여부
            long[] minEdge = new long[cnt]; // 정점 기준 최소 간선 비용
            
            StringTokenizer st;
            StringTokenizer st2;
         
            st = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) {
               int r= Integer.parseInt(st.nextToken());
               int c = Integer.parseInt(st2.nextToken());
               arr[j] = new island(r,c);
            }
            for (int i = 0; i < minEdge.length; i++) {
            	 minEdge[i] = Long.MAX_VALUE;	
			}
           
        // i노드에서 j노드까지의 비용을 모두 배열에 저장
            
            double E = Double.parseDouble(br.readLine());

            
            int minVertex = 0; // 최소 비용 연결 정점
            double min = 0; // 최소 비용
            double result = 0;
            
            minEdge[0] = 0; // 0 번째 정점의 최소 간선 비용은 0
            
            // cnt 만큼의 정점을 찾아간다.
    		for(int c = 0 ; c< cnt; c++){
    			
    			// 매번 정점 선택 전에 초기화
    			minVertex = 0;
                min = Double.MAX_VALUE;

                // 간선 비용이 최소인 c 번째 정점을 찾고 비용을 계산한다. ( 방문하지 않았고, 간선 비용이 최소인 i )
    			// i번째 정점에서 가장 작은 비용의 간선이 minEdge[i]. 현재 진행 기준으로 가장 작은 간선비용을 가진 정점이 minVertex
                // 간선 비용이 최소인 정점(minVertex) 를 찾는다.
                // 처음 시작할 때는 0정점만 0 나머지는 Integer.MAX_VALUE 이므로 시작 정점이 선택됨
                for(int i=0; i<cnt; ++i) { 
                	if(!visited[i] && minEdge[i] < min) { // 이미 방문한 정점 제외, min 반복문에서  항상 Integer.MAX_VALUE 로 초기화
                		min = minEdge[i];
                		minVertex = i;
                	}
                }	
                
                // 비용 계산 및 최소 간선 비용 정점 방문 처리
                result += E *min; 
                visited[minVertex] = true; 
                
                // 선택된 정점(minVertex)의 간선을 대상으로 최소 간선 비용을 계산한다. 
                // 최소 간선 비용으로 연결되는 다음 정점 i 의 최소 간선 비용을 계산하여 minEdge[i] 에 저장
                // 아직 선택되지 않은 정점 x minEdge[x] = Integer.MAX_VALUE
                for (int i = 0; i < cnt; i++) { 
                	long distance = getDistance(arr[minVertex].i,arr[i].i,arr[minVertex].j,arr[i].j);
                    if (!visited[i] && distance < minEdge[i] ) {
                    	minEdge[i] = distance;
                    }
                }
            }
            System.out.println("#"+test+" "+ Math.round(result));
        	
			
		}

    }
}// end class