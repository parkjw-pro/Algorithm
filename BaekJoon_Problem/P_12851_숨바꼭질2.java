package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_12851_숨바꼭질2 {
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();	
		boolean vis[] = new boolean[100001];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(N);
		vis[N] = true;
		int count = 0;
		int time = -1;
		boolean find =false;
		
		while(!queue.isEmpty()) {
			if(find) break;
			time = time+1;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				
				int current = queue.poll();
				vis[current] = true;
				if(current==K) {
					count++;
					find = true;
					continue;
				}
				if(current+1<100001&&!vis[current+1]) {
					//vis[current+1] = true;
					queue.offer(current+1);
				}
				if(current-1>-1&&!vis[current-1]) {
				//	vis[current-1] = true;
					queue.offer(current-1);
				}
				if(current*2<100001&&!vis[current*2]) {
				//	vis[current*2] = true;
					queue.offer(current*2);
				}
			}
		}
		System.out.println(time);
		System.out.println(count);
		sc.close();
	}
}