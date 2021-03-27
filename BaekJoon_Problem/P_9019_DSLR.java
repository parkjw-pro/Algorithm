package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_9019_DSLR {
	
	static int A,B;
	static boolean vis[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			
			vis = new boolean[10000];
			
			A = sc.nextInt();
			B = sc.nextInt();
			
			bfs();
		}
		
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<String> cal = new LinkedList<String>();
		queue.offer(A);
		cal.offer("");
		vis[A] =true;
		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			String c = cal.poll();
			
			if(current==B) {
				System.out.println(c);
				return;
			}

			
			if(current*2<=9999&&!vis[current*2]&&current>0) {
				vis[current*2] = true;
				queue.offer(current*2);
				cal.offer(c+"D");
				
			}else if(current*2>9999&&!vis[current*2%10000]) {
				vis[current*2%10000] = true;
				queue.offer(current*2%10000);
				cal.offer(c+"D");
			}
 


			
			if(current==0&&!vis[9999]) {
				vis[9999] = true;
				queue.offer(9999);
				cal.offer(c+"S");
			}
			
			if(current>0&&!vis[current-1]) {
				vis[current-1] = true;
				queue.offer(current-1);
				cal.offer(c+"S");
			}
            int L = (current % 1000) * 10 + current/1000;
            int R = (current % 10) * 1000 + current/10;  
            
			if(current>0&&!vis[L]) {
				vis[L] = true;
				queue.offer(L);
				cal.offer(c+"L");
			}
			
			if(current>0&&!vis[R]) {
				vis[R] = true;
				queue.offer(R);
				cal.offer(c+"R");
			}

		}
	}
}
