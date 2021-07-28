package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_16953_ATOB {
	
	static int A;
	static int B;
	static boolean vis[];
	static int answer = 0;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		vis = new boolean[1000000001];
		bfs();
		if(answer==0) {
			System.out.println(-1);
		}else {
			System.out.println(answer+1);
		}
		

	}
	private static void bfs() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(A);
		if(A == B) return;
		vis[A] = true;
		int count = 0;
		
		while(!queue.isEmpty()) {
			
			
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				
				int n = queue.poll();
				if(n == B) {
					answer = count;
					return;
				}
				if(n<=500000000&&!vis[n*2]) {
					queue.add(n*2);
					vis[n*2] = true;
				}
				if(n<100000000&&!vis[n*10+1]) {
					queue.add(n*10+1);
					vis[n*10+1] = true;
				}
				

			}
			count++;
			

			
		}
		
	}

}
