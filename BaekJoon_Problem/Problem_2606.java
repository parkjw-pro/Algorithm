package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2606 {

	static int count;
	static int N,M;
	static boolean vis[];
	static ArrayList<Integer> arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		vis = new boolean[N];
		
		arr = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			
			arr[i] = new ArrayList<Integer>();
			
		}
		for (int i = 0; i < M; i++) {
			
			int from = sc.nextInt();
			int to = sc.nextInt();
			arr[from-1].add(to-1);
			arr[to-1].add(from-1);
		}
		bfs(0);
		System.out.println(count);

	}
	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		count = 0; 
		
		int current = num;
		vis[current] = true;
		queue.offer(current);
		
		while(!queue.isEmpty()) {
			
			current = queue.poll();
			
			for( int temp  : arr[current]) {
				
				if(!vis[temp]) {
					vis[temp] = true;
					queue.offer(temp);
					count++;
				}
			}
		}
	}
}