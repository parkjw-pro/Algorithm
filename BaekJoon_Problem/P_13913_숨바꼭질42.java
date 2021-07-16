package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_13913_숨바꼭질42 {
	
	static int N;
	static int K;
	static boolean vis [];
	static int path[];
	static int answer1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

		vis = new boolean[100001];
		path = new int[100001];
		answer1 = Integer.MAX_VALUE;
		
		bfs();
		
		StringBuilder sb = new StringBuilder();
		
		int next = K;
		
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(K);
		int k2 = K;
		while(k2!=N) {
			next = path[k2];
			stack.add(next);
			k2 = next;
			
		}
		System.out.println(stack.size()-1);
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		
		System.out.println(sb);
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(N);
		
		if(N==K) {
			answer1 = 0;
			return;
		}
		while(!queue.isEmpty()) {
				
				int n = queue.poll();
				
				if(n==K) {
					return;
				}
				
				if(n+1<=100000&&!vis[n+1]) {
					queue.add(n+1);
					path[n+1] = n;
					vis[n+1] = true;
				}
				if(n-1>=0&&!vis[n-1]) {
					queue.add(n-1);
					path[n-1] = n;
					vis[n-1] = true;
				}
				if(n*2<=100000&&!vis[n*2]) {
					queue.add(n*2);
					path[n*2] = n;
					vis[n*2] = true;
				}
		}
	}
}