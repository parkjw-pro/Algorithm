package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1679 {
	
	static int N,M;
	static Queue<Integer>  queue= new LinkedList<Integer>();
	static Queue<Integer>  depth= new LinkedList<Integer>();
	static boolean[] vis = new boolean[100001];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	    N = sc.nextInt();
		M = sc.nextInt();

		queue.offer(N);
		depth.offer(0);
			
		bfs();
		sc.close();
	}

	private static void bfs() {

		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			int count = depth.poll();
			
			if(current==M) {
				System.out.println(count);
				break;
			}
			if(!vis[current]) {
				vis[current] = true;
				
				if(current-1>=0) {queue.offer(current-1); depth.offer(count+1);}
				if(current*2<=100000) { queue.offer(current*2);depth.offer(count+1);}
				if(current+1<=100000) { queue.offer(current+1);depth.offer(count+1);}
			}
		}
	}
}