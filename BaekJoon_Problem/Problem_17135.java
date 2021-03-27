package com.ssafy;

import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class Problem_17135 {
	
	static class sniper {
		
		int a, b, c;
		
		
		public sniper(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
//		@Override
//		public String toString() {
//			return "sniper [a=" + a + ", b=" + b + ", c=" + c + "]";
//		}
	}
	static int dx[] = {-1,0,0};
	static int dy[] = {0,-1,1};
	static int N,M,A,map[][], map_copy[][];
	static sniper[] sniperlist;
	static int kill_max;
	static int kill_cnt;
	static int[] numbers = new int[3];
	static int sniper_num = 0;
	static boolean shooted[] = new boolean[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		A = sc.nextInt();
		sniperlist = new sniper[(M)*(M-1)*(M-2)/6];
		map_copy = new int[N+1][M];
		map = new int[N+1][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}  
		
		
		set_sniper(0,0);
		
		
		for (int i = 0; i < sniperlist.length; i++) {
			
			map_copy = map;
			offense(sniperlist[i]);
		}
	}

	
	
	private static void offense (sniper s) {
		
		for (int i = N-1; i >= 0; i--) {
			for (int k = 0; k < M; k++) {
				distance(i,k,s);
				
			}
			for (int j = 0; j < M; j++) {
				map[i][j] = 0;
				
			}
		}
	}
	
	private static void set_sniper(int cnt, int start) {
		
		if(cnt==3) {
			
				int a = numbers[0];
				int b = numbers[1];
				int c = numbers[2];
				sniperlist[sniper_num++] = new sniper(a,b,c); 
				return;
		}

		for (int j = start; j < N; j++) {
			numbers[cnt]= j;
			set_sniper(cnt+1, j+1);
		
		}
	}
	
	private static void distance(int y,int x , sniper s) {
		boolean shot;
		
		for (int i = 1; i <= A; i++) {
			for (int j = 0; j < M; j++) {
				if(map[y][j]==1&&Math.abs(1)+Math.abs(x-s.a)==i) {
					map_copy[y][j]= 0;
					shot=true;
					break;
				}


			if(map[y][x]==1&&Math.abs(1)+Math.abs(x-s.b)==i) {
				map_copy[y][x]= 0;
				break;
			}
			if(map[y][x]==1&&Math.abs(1)+Math.abs(x-s.c)==i) {
				map_copy[y][x]= 0;
				break;
			}
		} 
	}
	}
}
