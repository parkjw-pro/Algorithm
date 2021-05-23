package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_2458_키순서 {
	
	static int N,M;
	static ArrayList<Integer> arr[];
	static ArrayList<Integer> arr2[];
	
	//자기 아래 + 자기 위 = n-1을 만족하는 학생의 갯수를 카운트한다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		
		 arr = new ArrayList[N];
		 arr2 = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<Integer>();
			arr2[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			arr[b].add(a);
			arr2[a].add(b);
			
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int a = bfs1(i);
			int b = bfs2(i);
		//	System.out.println("low : "+a+" high : "+b);
			if(a+b==N-1) {
				answer++;
			}
		}
		
		System.out.println(answer);

		

	}
	private static int bfs1(int a) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(a);
		int count = 0;
		boolean vis[] = new boolean[N];
		
		while(!queue.isEmpty()) {
			int c = queue.poll();
		//	System.out.println("size : "+arr[c].size());
			
			for (int i = 0; i < arr[c].size(); i++) {

				if(vis[arr[c].get(i)]) continue;
				queue.add(arr[c].get(i));
				vis[arr[c].get(i)] = true;
				count ++;
			}
		}
		return count;
		
	}
	private static int bfs2(int a) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(a);
		int count = 0;
		boolean vis[] = new boolean[N];
		
		while(!queue.isEmpty()) {
			int c = queue.poll();
		//	System.out.println("size : "+arr[c].size());
			
			for (int i = 0; i < arr2[c].size(); i++) {

				if(vis[arr2[c].get(i)]) continue;
				queue.add(arr2[c].get(i));
				vis[arr2[c].get(i)] = true;
				count ++;
			}
		}
		return count;

	}

}
