package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class P_3234_준환이의양팔저울 {
	
	static int N,num[];
	static int wt[][];
	static int answer;
	static int sum_R;
	static int sum_L;
	static boolean vis[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int testcase = 1; testcase <= T; testcase++) {
			
			int N = sc.nextInt();
			answer = 0;
			sum_R=0;
			sum_L=0;
			num = new int[N];
			wt = new int [2][N];
			vis = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			Arrays.sort(num);
			setweight(0,0,0);
			System.out.println("#"+testcase+" "+answer);
		}
	}
	private static void setweight(int r,int sr, int sl) {

		if(r == num.length) {
			answer++;
			return;
		}else {
		for (int i = r; i < num.length; i++) {
			
            int temp = num[r];
            num[r] = num[i];
            num[i] = temp;
			

			setweight(r+1,sr,sl+num[r]);
			if(sl>=sr+num[r]) {
				setweight(r+1,sr+num[r],sl);
			}
			
            temp = num[r];
            num[r] = num[i];
            num[i] = temp;

		}
	}
}}