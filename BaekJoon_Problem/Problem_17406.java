package com.ssafy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Problem_17406 {
	
	static class roll_cal{
		int r;
		int c;
		int s;
		public roll_cal(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
		@Override
		public String toString() {
			return "roll_cal [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
		
	}
	static int N,M,arr[][],roll_c;
	static List<roll_cal> rc = new ArrayList<roll_cal>();
	static roll_cal rc2[];
	static boolean isSelected[];
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static int min = 5001;

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		roll_c = sc.nextInt();
		arr = new int[N][M];
		rc2 = new roll_cal[roll_c];
		isSelected = new boolean[roll_c];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < roll_c; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			rc.add(new roll_cal(r-1,c-1,s));
		}
		combRoll(0);
		System.out.println(min);
		sc.close();
	}
	
	
	public static void combRoll(int cnt) {
		if(cnt == roll_c) {
			roll_arr(rc2);
			return;
		}
		for (int i = 0; i < rc.size(); i++) {
			if(isSelected[i]) continue;
			rc2[cnt] = rc.get(i);
			isSelected[i] = true;
			combRoll(cnt+1);
			isSelected[i] = false;
		}
	}
	public static void roll_arr(roll_cal rc[]) {
		int arrcopy[][] = new int[N][M];
		int arrcopy2[][] = new int[N][M];
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < M; j++) {
				arrcopy[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < M; j++) {
				arrcopy2[i][j] = arr[i][j];
			}
		}
		int k=0 , k1 = 0;
		for (roll_cal r : rc) {
			for (int i = 0; i < r.s; i++) {
				for (int j = 0; j < 4; j++) {
					int x1 = r.r-r.s+i+k;
					int x2 = r.c-r.s+i+k1;
					for (int j1 = 1; j1 <= (r.s-i)*2; j1++) {
						arrcopy[x1+dy[j]*(j1)][x2+dx[j]*(j1)] = 
								arrcopy2[x1+dy[j]*(j1-1)][x2+dx[j]*(j1-1)];
						k = k+dy[j];
						k1 = k1 + dx[j];
					}
				}
			}
			for (int i = 0; i <N; i++) {
				for (int j = 0; j < M; j++) {
					arrcopy2[i][j] = arrcopy[i][j];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum = sum +  arrcopy[i][j];
			}
			if(sum<=min) {
				min = sum;
			}
		}
	}
}