package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1225_D3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			Queue<Integer> queue = new LinkedList<Integer>();
			
			int N;
			boolean zero=true;
			int t_n = sc.nextInt();
			
			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());}
			
			while(zero) {
				for (int i = 1; i < 6; i++) {
					N = queue.peek()-i;
					if(N<=0) {
						N = 0;
						queue.poll();
						queue.offer(N);
						zero=false;
						break;
					}
					queue.poll();
					queue.offer(N);
				}
			}
			System.out.print("#"+ t_n+" ");
			for (int i = 0; i < 8; i++) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println("");
		}
	}
}