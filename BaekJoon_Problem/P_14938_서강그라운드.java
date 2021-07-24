package com.ssafy;

import java.util.Scanner;



public class P_14938_서강그라운드 {
	

	
	static int n;//정점갯수
	static int m;//최대갈수있는거리
	static int r;//간선수
	static int items[];//지역마다 아이템 갯수수
	static int arr[][];//배열
	static int answer;//답

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		items = new int[n];
		arr = new int[n][n];
		answer = 0;
		for (int i = 0; i < n; i++) {
			items[i] = sc.nextInt();
		}
		
		for (int i = 0; i < r; i++) {
        	int from = sc.nextInt()-1;
        	int to = sc.nextInt()-1;
        	int weight = sc.nextInt();
  
	        arr[from][to]= weight;
	        arr[to][from]= weight;
		}
		

         for (int v = 0; v < n; v++) {
     		int distance[] = new int[n];          //최단 거리를 저장할 변수
            boolean[] check = new boolean[n];     //해당 노드를 방문했는지 체크할 변수
             
            //distance값 초기화.
            for(int i=0; i<n;i++){
                distance[i] = Integer.MAX_VALUE;
            }
            
            //시작점에서 i점까지의 거리
            
			 //시작노드값 초기화.
	        distance[v] =0;
	        check[v] =true;
	         
	        //연결노드 distance갱신
	        for(int i=0; i<n;i++){
	            if(!check[i] && arr[v][i] !=0){
	            	
	            	//들리지 않고 바로 가는 길을 distance배열에 넣음.
	                distance[i] = arr[v][i];
	            }
	        }
	         
	        //시작점이 정해져있고, 시작점에서 직행하는 길이 distance배열에 들어가고,
	        //시작점과 연결되어있지 않은 점들은 distance배열에 최대값으로 저장되어있다.
	        
	         
	        
	        for(int a=0; a<n-1;a++){
	            //원래는 모든 노드가 true될때까지 인데
	            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
	            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
	        	
	        	//거리의최솟값
	            int min=Integer.MAX_VALUE;
	            
	            //해당 최솟값을 가지는 정점의 위치
	            int min_index=-1;
	             
	          //시작점이 정해져있고, 시작점에서 직행하는 길이 distance배열에 들어가고,
		        //시작점과 연결되어있지 않은 점들은 distance배열에 최대값으로 저장되어있다.
	            
	            
	            //최소값 찾기
	            for(int i=0; i<n;i++){
	                if(!check[i] && distance[i]<=min){
	                	min=distance[i];
	                	min_index = i;
	                    
	                }
	            }
	            
	            check[min_index] = true;
	            
	            
	            //해당 점을 갔을때, 다른 점을 돌아가는게 유리한지, 아니면 그냥 바로가는게 유리한지 판단
	            for(int i=0; i<n;i++){
	                if(arr[min_index][i]!=0&&!check[i]){
	                    if(distance[i]>distance[min_index]+arr[min_index][i]){
	                        distance[i] = distance[min_index]+arr[min_index][i];
	                    }
	                }
	            }
	            int sum = 0;
	            for (int i = 0; i < n; i++) {
	            	
					if(distance[i]<=m) {
						
						sum = sum + items[i];
					}
				}
	            answer = Math.max(answer, sum);
	            
	        }
         }
         System.out.println(answer);
         
	}
}
