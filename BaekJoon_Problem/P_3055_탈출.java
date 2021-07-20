package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_3055_탈출 {
	
	static int R;
	static int C;
	static char arr[][];
	static Queue<Integer> queues;
	static int si;
	static int sj;
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static boolean vis[][];
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		queues = new LinkedList<Integer>();
		vis = new boolean[R][C];
		sc.nextLine();
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.nextLine();
			arr[i] = s.toCharArray();
			
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j]=='*') {
					queues.add(i);
					queues.add(j);
				}else if(arr[i][j]=='S') {
					si = i;
					sj = j;
				}
			}
		}
		
		bfs();
		if(answer==0) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(answer);
		}
		
		
		
		

	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		
		queue.add(si);
		queue.add(sj);
		queue2.add(0);
		vis[si][sj] = true;
		
		while(!queue.isEmpty()) {
			
			int size1 = queues.size()/2;
			
			for (int i = 0; i < size1; i++) {
				
				int wateri = queues.poll();
				int waterj = queues.poll();
				
				for (int j = 0; j < 4; j++) {
					int waterni = wateri + dy[j];
					int waternj = waterj + dx[j];
					
					if(waterni<0||waternj<0||waterni>=R||waternj>=C||arr[waterni][waternj]!='.') continue;
					arr[waterni][waternj] = '*';
					queues.add(waterni);
					queues.add(waternj);
				//	System.out.println(waterni+" "+waternj);
					
				}
			}
			
			int size2 = queue.size()/2;
			for (int i = 0; i < size2; i++) {
				int animali = queue.poll();
				int animalj = queue.poll();
				int count = queue2.poll();
				

				
				for (int j = 0; j < 4; j++) {
					int animalni = animali + dy[j];
					int animalnj = animalj + dx[j];
					
					if(animalni<0||animalnj<0||animalni>=R||animalnj>=C||
							vis[animalni][animalnj]) continue;
					
					
					if(arr[animalni][animalnj] =='D') {
						answer = count+1;
						return;
					}
					if(arr[animalni][animalnj]!='.') continue;
					
					
					queue.add(animalni);
					queue.add(animalnj);
					queue2.add(count+1);
					vis[animalni][animalnj] = true;
					
				}
				
				
			}
		}
		
	}

}
