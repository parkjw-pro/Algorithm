package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_5014 {

	static boolean vis[] = new boolean[1000001]; 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();

		Queue<position> queue = new LinkedList<position>();
		queue.offer(new position(S,0));
		while(!queue.isEmpty()) {
			
			position p = queue.poll();
			if(vis[p.height]) continue;
			else {vis[p.height] = true;}
			
			if(p.height==G) {System.out.println(p.count); return;}
			
			if(p.height+U<=F) {
				queue.offer(new position(p.height+U,p.count+1));
				
			}
			if(p.height-D>0) {
				queue.offer(new position(p.height-D,p.count+1));
			}
		}
		System.out.println("use the stairs");
	}
	static class position{
		
		public int height;
		public int count;
		public position(int height, int count) {
			super();
			this.height = height;
			this.count = count;
		}
	}
}