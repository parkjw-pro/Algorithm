package com.ssafy;

import java.util.ArrayList;
import java.util.Scanner;

public class P_10888_음식배달 {
	
	static class chick{
		
		int r;
		int c;
		int cost;
		public chick(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		
	}
	
	static int N,arr[][];
	static ArrayList<chick> list;
	static boolean vis[];
	static int count;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test = 1; test <= T; test++) {
			
			
			N = sc.nextInt();
			arr = new int[N][N];
			list = new ArrayList<chick>();
			count = 0;
			answer = 100000;
		
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j]>1) {
						list.add(new chick(i,j,arr[i][j]));
						count++;
					}
				}
			}
			vis = new boolean[count];
			go(0);
			
			System.out.println("#"+test+" "+answer);
			
		}

	}
	private static void go(int cnt) {

			
		if( cnt !=0 &&cnt == count) {
			int sumchick = 0;
			for (int i = 0; i < count; i++) {
				if(vis[i] == true) {
					sumchick = sumchick + list.get(i).cost;
				}
			}
			answer = Math.min(answer, caldistance()+sumchick);
			//System.out.println(answer);
			return;
		}
			
		vis[cnt] = true;
		go(cnt+1);
		vis[cnt] = false;
		go(cnt+1);

		
	}
	private static int caldistance() {
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				
				
				if(arr[i][j]==1) {
					int distochick = 500;
					for (int j2 = 0; j2 < count; j2++) {
						if(vis[j2]) {
							int dis = Math.abs(i-list.get(j2).r) +
									Math.abs(j-list.get(j2).c);
	
							distochick = Math.min(distochick, dis);
						}
					}
					sum = sum + distochick;
				}
				
				
				
			}
		}

		return sum;
		
	}

}
