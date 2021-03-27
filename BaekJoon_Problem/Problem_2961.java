package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Problem_2961 {
	
	
	static class material implements Comparable<material>{
		
		int sin,sseun;
		
		public material(int sin, int sseun) {
			super();
			this.sin = sin;
			this.sseun = sseun;
		}

		@Override
		public int compareTo(material o) {
			
			return Integer.compare(Math.abs(this.sin-this.sseun), Math.abs(sin-sseun));
		}
	}
	
	
	static int N;
	static material[] materiallist;
	static int sum[] = new int[2];
	static boolean[] isSelected;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
	
		
		
		N = Integer.parseInt(st.nextToken());
		
		materiallist = new material[N];
		isSelected = new boolean[N];

		int sin,sseun;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine().trim());
			sin = Integer.parseInt(st.nextToken());
			sseun = Integer.parseInt(st.nextToken());
			
			materiallist[i] = new material(sin,sseun);
		}

	//	Arrays.sort(materiallist);
		
		min = Math.abs(materiallist[0].sin- materiallist[0].sseun);

		make_food(0);
		System.out.println(min);
	}
	
	private static void make_food(int i) {
		
		boolean find = false;

		if(i == N) {
			sum[0] = 1;
			sum[1] = 0;
			for (int j = 0; j < N; j++) {
				if(isSelected[j]) {
						sum[0]=sum[0]* materiallist[j].sin;
						sum[1]= sum[1]+ materiallist[j].sseun;
						find = true;
				}
			}
			if(!find) return;
			if(sum[1]!=0&&Math.abs(sum[0]-sum[1])<=min){
				min = Math.abs(sum[0]-sum[1]);
			}
			return;
		}
		isSelected[i] = true;
		make_food(i+1);
		isSelected[i]= false;
		make_food(i+1);
	}
}
