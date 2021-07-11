package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2577_회전초밥 {
	
	static int N,d,k,c,map[];
	static int max=0;
	static int sel[];
	static int count = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[N+k-1];
		sel = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(in.readLine());
		}
		in.close();
		for (int i = 0; i < k-1; i++) {
			map[N+i]=map[i];
		}
		sel[c] = 1;
		choice();
		System.out.println(max);
	}
	private static void choice() {
		for (int i = 0; i <k; i++) {
			
			if(sel[map[i]]==0) {count++;}
			sel[map[i]]++;
			max = Math.max(max, count);
		}
		for (int i = k; i < map.length; i++) {
			
			if(sel[map[i-k]]==1) {count--;}
			sel[map[i-k]]--;
			if(sel[map[i]]==0) {count++;}
			sel[map[i]]++;
			max = Math.max(max, count);
		}
	}
}