package com.ssafy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P_1927_최소힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num==0) {
				if(queue.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(queue.poll());
				}
			}else {
				queue.offer(num);
			}
		}
	}
}
