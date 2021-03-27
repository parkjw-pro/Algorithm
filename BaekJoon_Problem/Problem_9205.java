package com.ssafy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Problem_9205 {
	
	static class store implements Comparable<store>{
		int i;
		int j;
		int dis;
		
		public store(int i, int j,int dis) {
			super();
			this.i = i;
			this.j = j;
			this.dis = dis;
		}
		@Override
		public int compareTo(store o) {
			return Integer.compare(this.dis, o.dis);
		}
		@Override
		public String toString() {
			return i+" "+j+" "+ dis+" ";
		}
	}
	
	static int T,N;
	static int h_i,h_j;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			go();
		}
	}
	public static void go() {
		N= sc.nextInt();
		 ArrayList<store> list = new ArrayList<>();
	//	static int h_i = sc.nextInt();
		int h_j = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b= sc.nextInt();
			list.add(new store(a,b,(Math.abs(h_i-a)+Math.abs(h_j-b))));
		}
		Collections.sort(list);
		
		int f_i = sc.nextInt();
		int f_j = sc.nextInt();
		
		if((Math.abs(h_i-f_i)+(Math.abs(h_j-f_j)))<=1000){
			
			System.out.println("happy");
			return;
		}
		for (store s : list) {
			if((Math.abs(h_i-s.i)+(Math.abs(h_j-s.j)))>1000){
				System.out.println("sad");
				return;
			}
			h_i=s.i;
			h_j=s.j;
			if((Math.abs(h_i-f_i)+(Math.abs(h_j-f_j)))<=1000){
				System.out.println("happy");
				return;
			}
		}
		System.out.println("sad");
	}
}