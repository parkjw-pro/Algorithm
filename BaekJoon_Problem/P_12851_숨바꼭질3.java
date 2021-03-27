package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_12851_숨바꼭질3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean vis[] = new boolean[100001];

		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		queue.offer(N);
		queue2.offer(0);
		vis[N] = true;
		int answer = Integer.MAX_VALUE;



		while (!queue.isEmpty()) {

			int current = queue.poll();
			int count = queue2.poll();
			vis[current] = true;
			if (current == K) {
				if(answer<count) continue;
				
				answer = Math.min(answer, count);
				continue;
			}
			if (current + 1 < 100001 && !vis[current + 1]) {
				// vis[current+1] = true;
				queue.offer(current + 1);
				queue2.offer(count + 1);
			}
			if (current - 1 > -1 && !vis[current - 1]) {
				// vis[current-1] = true;
				queue.offer(current - 1);
				queue2.offer(count + 1);
			}
			if (current * 2 < 100001 && !vis[current * 2]) {
				// vis[current*2] = true;
				queue.offer(current * 2);
				queue2.offer(count);
			}

		}
		System.out.println(answer);

		sc.close();
	}
}