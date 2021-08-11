package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P_12852_1로만들기2 {
	
	static int N;
	static int vis[];
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N =sc.nextInt();
		vis = new int[1000001];
		
		bfs();
		if(answer == 0) {
			System.out.println(answer);
			System.out.println(1);
		}else {
			System.out.println(answer);
			Stack<Integer> stack = new Stack<Integer>();
			stack.add(1);
			int index = 1;
			while(true) {
				stack.add(vis[index]);
				index = vis[index];
				if(index==N) break;
			}
			while(!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
		}
		


	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(N);
		vis[N] = N;
		if(N==1) {
			return;
		}
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				int n = queue.poll();
				if(n==1) {
					return;
				}
				if(n%3==0&&vis[n/3]==0) {
					vis[n/3] = n;
					queue.add(n/3);
				}
				if(n%2==0&&vis[n/2]==0) {
					vis[n/2] = n;
					queue.add(n/2);
				}
				if(n>0&&vis[n-1]==0) {
					vis[n-1] = n;
					queue.add(n-1);
				}
			}
			answer++;
		}
	}

}
