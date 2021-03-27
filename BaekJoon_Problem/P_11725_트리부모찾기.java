package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_11725_트리부모찾기 {
	
	static int N,parents[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		parents = new int[N+1];
		ArrayList<Integer> list[] = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N-1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[from].add(to);
			list[to].add(from);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(1);
		parents[1] = 1;
		
		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			for (int a : list[current]) {
				if(parents[a]==0) {
					parents[a] = current;
					queue.offer(a);
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}
}
