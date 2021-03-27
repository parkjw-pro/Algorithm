package com.ssafy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class P_1463_1로만들기 {
	static int N;
	static boolean vis[] = new boolean[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		bfs();
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> count_q = new LinkedList<Integer>();
		queue.offer(N);
		count_q.offer(0);
		vis[N] =true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			int count = count_q.poll();
			if(current==1) {
				System.out.println(count);
				return;
			}
			if(!vis[current/3]&&current%3==0) {
				
				vis[current/3]= true;
				queue.offer(current/3);
				count_q.offer(count+1);
			}
			if(!vis[current/2]&&current%2==0) {
				
				vis[current/2]= true;
				queue.offer(current/2);
				count_q.offer(count+1);
			}
			
			
			
			if(!vis[current-1]&&current-1>0) {
				vis[current-1]= true;
				queue.offer(current-1);

				
				
				
				
				count_q.offer(count+1);
			}
		}
	}
}