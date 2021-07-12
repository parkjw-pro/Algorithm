package com.ssafy;


import java.util.*;
import java.io.*;


public class Problem_1863 {
	
	static int[] parents;
	static int [] deep;
	static int N ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		

		N =  Integer.parseInt(tk.nextToken());
		parents = new int[N+1];
		deep = new int[N+1];
		make();
		int M =  Integer.parseInt(tk.nextToken());
		
		
		
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(tk.nextToken());
			int from = Integer.parseInt(tk.nextToken());
			union( to, from);
			
		}
		int cnt = 0;
        for(int i = 1; i<=N; i++) {
            if(i == parents[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);

	}
	
	static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(parents[a]==a) return a;
		return find(parents[a]);
	}

	static  void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		  if(deep[aRoot]<deep[bRoot]) {  // 트리의 깊이를 서로 비교해서 작은것을 큰것아래에 붙인다.(트리의 깊이 최소화)
	            parents[aRoot] = bRoot;  
	        }
	        else {
	            parents[bRoot] = aRoot;
	            if(deep[aRoot] == deep[bRoot]) {
	            	deep[aRoot]++;
	            }
	        }
	}
}
