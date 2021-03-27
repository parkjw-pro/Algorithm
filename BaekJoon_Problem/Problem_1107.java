package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1107 {
	
	static int M,arr[],min;
	static String N;
	static boolean vis[] = new boolean[1000001];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.next();
		M = sc.nextInt();
		arr = new int[10-M];
		int arr2[] = {0,1,2,3,4,5,6,7,8,9};
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			arr2[num] = -1;
		}
		int k = 0;
		for (int i = 0; i < 10; i++) {
			if(arr2[i]!=-1) {
				arr[k++]=arr2[i];
			}
		}
		
		min = Math.abs(Integer.parseInt(N)-100);

		bfs(100);
		System.out.println(min);
	}
	public static void bfs(int start) {
		Queue<String> queue = new LinkedList<String>();
		Queue<Integer> count_queue = new LinkedList<Integer>();
		
		queue.offer(Integer.toString(start));
		count_queue.offer(0);
		int number = N.length();
		
		
		while(!queue.isEmpty()) {
			
			String cur = queue.poll();
			int current = Integer.parseInt(cur);
			int count = count_queue.poll();
			
			if(Math.abs(cur.length()-N.length())<2) {
				if(count+Math.abs(Integer.parseInt(N)-current)<min) {
					min = count+Math.abs(Integer.parseInt(N)-current);
					System.out.println(min);
				}
			}
						
			if(number==(N.length())) { cur="";}
			for (int  a : arr) {
				if(Integer.parseInt(cur+Integer.toString(a))>1000000||vis[Integer.parseInt(cur+Integer.toString(a))]) {continue;}
				queue.offer(cur+Integer.toString(a));
				count_queue.offer(count+1);
				vis[Integer.parseInt(cur+Integer.toString(a))]= true;
			}
			number--;
		}
	}
}