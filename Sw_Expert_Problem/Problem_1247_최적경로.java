package com.ssafy;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_1247_최적경로 {
	
	static class client{
		int i;
		int j;
		public client(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	static int N,oi,oj,hi,hj;
	static ArrayList<client> cl;
	static client cl2[];
	static boolean vis[];
	static int min ;
	static int cn = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int testcase = 1; testcase <= T; testcase++) {
			
			min = 100000;
			cl = new ArrayList<client>();
			N = sc.nextInt();
			cl2 = new client[N];
			vis = new boolean[N];
			
			oi = sc.nextInt();
			oj = sc.nextInt();
			hi = sc.nextInt();
			hj = sc.nextInt();
			
			
			for (int i = 0; i < N; i++) {
				int ci = sc.nextInt();
				int cj = sc.nextInt();
				cl.add(new client(ci,cj));
			}
			per_cli(0);
			
			System.out.println("#"+testcase+" "+min);
		//	System.out.println(cn);
		}

	}
	private static void per_cli(int cnt) {
		if(cnt==N)
		{
			startdel(cl2);
			//cn ++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if(vis[i]) {continue;}
			cl2[cnt] = cl.get(i);
			vis[i] = true;
			per_cli(cnt+1);
			vis[i] = false;
		}
	}
	private static void startdel(client[] sel_cl) {
		int sum = Math.abs(oi-sel_cl[0].i)+
				Math.abs(oj-sel_cl[0].j);
		
		for (int k = 0; k < sel_cl.length-1; k++) {
			int dis = Math.abs(sel_cl[k].i-sel_cl[k+1].i)+
					Math.abs(sel_cl[k].j-sel_cl[k+1].j);
			sum = sum + dis;
		}
		
		sum = sum+ Math.abs(hi-sel_cl[sel_cl.length-1].i)+
				Math.abs(hj-sel_cl[sel_cl.length-1].j);
		
		if(sum<=min) {
			min = sum;
		}
	}
}