package com.ssafy;

import java.util.Scanner;

public class P_2112_보호필름 {
	
	static int D;
	static int W;
	static int K;
	static int arr[][];
	static int arrc[][];
	static int answer;
	static int Aarr[];
	static int Barr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			arr = new int[D][W];
			arrc = new int[D][W];
			answer = Integer.MAX_VALUE;
			Aarr = new int[W];
			Barr = new int[W];
			for (int i = 0; i < W; i++) {
				Aarr[i] = 0;
				Barr[i] = 1;
			}
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					arr[i][j] = arrc[i][j] =sc.nextInt();
				}
			}
			
			dfs(arrc,0,0);
			
			System.out.println("#"+t+" "+answer);
			
			
		}

	}
	private static void dfs(int[][] map, int n, int cnt) {
		
		if(n==D) {
//			System.out.println();
			boolean flag2 = false;
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map.length; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			for (int i = 0; i < W; i++) {
				int count = 1;
				
				//아예 못찾을거면 나온다.
				if(flag2) break;
				
				for (int j = 0; j < D-1; j++) {
					if(map[j][i] == map[j+1][i]) {
						count++;
					}else {
						count = 1;
					}
					if(count>=K) {
						break;
					}
					if(count==1&&D-j<=K) {
						flag2 = true;
						break;
					}
				}
			}
			
			
			
			
			//조건 만족 안하면
			if(flag2) {
				return;
			}
			//만족하면
			answer = Math.min(answer, cnt);
			return;
		}
		
		dfs(map,n+1,cnt);
		
		map[n] = Aarr;
		dfs(map,n+1,cnt+1);
		
		map[n] = Barr;
		dfs(map,n+1,cnt+1);
		
		map[n] = arr[n];
		
	}

}
