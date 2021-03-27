package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_3190_뱀 {
	
	static class dir{
		
		int time;
		char d;
		public dir(int time, char d) {
			super();
			this.time = time;
			this.d = d;
		}
	}
	
	static int N,K,L,arr[][];
	static ArrayList<dir> list;
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][N];
		
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			arr[r][c] = 1;
		}
		
		L = sc.nextInt();
		list = new ArrayList<dir>();
		for (int i = 0; i < L; i++) {
			int x = sc.nextInt();
			String s = sc.next();
			list.add(new dir(x,s.charAt(0)));
			//System.out.println(s.charAt(0));
		}
		int d = 0;
		int t = list.get(0).time;
		char nextd = list.get(0).d;
		Queue<Integer> queue2 = new LinkedList<Integer>();
		queue2.add(0);
		queue2.add(0);
		
		
		int result = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean vis[][] = new boolean[N][N];
		queue.add(0);
		queue.add(0);
		vis[0][0] = true;
		int k = 0;
		boolean last = false;
		while(!queue.isEmpty()) {

			int ny = queue.poll();
			int nx = queue.poll();
			
			for (int i = 1; i < 15000; i++) {
				result = result + 1;
				ny = ny + dy[d];
				nx = nx + dx[d];
				
				if(ny<0||nx<0||ny>=N||nx>=N||vis[ny][nx]) {
					System.out.println(result);
					System.exit(0);
				}
				//System.out.println("R : "+ny+" C : "+nx);
				
				queue2.add(ny);
				queue2.add(nx);
				vis[ny][nx]=true;
				
				if(arr[ny][nx]==1) {
					arr[ny][nx]=0;
					
				}else {
					
					vis[queue2.poll()][queue2.poll()] = false;
				}

				if(!last) {
					
					if(i==list.get(k).time) {
						k = k+1;
						//System.out.println("change");
						
						if(k==list.size()) {
							if(nextd =='D')  d = (d+1)%4;
							if(nextd =='L')  d = (d+3)%4;
							last = true;

						}else {
							if(nextd =='D')  d = (d+1)%4;
							if(nextd =='L')  d = (d+3)%4;
							nextd = list.get(k).d;
							//System.out.println("result : "+result);
							queue.add(ny);
							queue.add(nx);
						}
					}
				}
			}
		}
	}
}
