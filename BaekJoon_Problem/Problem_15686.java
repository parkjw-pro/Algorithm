package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem_15686 {
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int N,M,map[][];
	static int answer = 2500;
	static List<chick> ch = new ArrayList<chick>();
	static chick ch2[];
	
	static class chick{
		int i;
		int j;
		public chick(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		ch2 = new chick[M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1) {
					queue.offer(i);
					queue.offer(j);
					
				}else if(map[i][j]==2) {
					ch.add(new chick(i , j));
				}
			}
		}
		
		set_chick(0,0);
		System.out.println(answer);
		sc.close();
	}
	
	public static void bfs(chick ch2[]) {
		
		Queue<Integer> queue2 = new LinkedList<Integer>();
		queue2.addAll(queue);
	 	//queue2 = queue ;
//		할경우 queue2.poll을 했을때도 queue가 poll되면서 빠진다.
		
		int sum = 0;
		while(!queue2.isEmpty()) {
			
			int current_i = queue2.poll();
			int current_j = queue2.poll();
			int comp = 2500;
			for (chick c : ch2) {
				int k = Math.abs(current_i-c.i) + Math.abs(current_j-c.j);
				if(k<=comp) {
					comp = k;
				}
			}
			sum = sum + comp;
		}
		if(sum<=answer) {
			answer = sum;
		}
	}
	private static void set_chick(int cnt, int start) {
		
		if(cnt==M) {
			bfs(ch2); 
			return;
		}
		for (int j = start; j < ch.size(); j++) {
			//System.out.println(cnt+" "+j);

			ch2[cnt] = ch.get(j);
			set_chick(cnt+1, j+1);
		}
	}
}
