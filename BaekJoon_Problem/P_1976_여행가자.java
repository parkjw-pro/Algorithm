package com.ssafy;

import java.util.Scanner;

public class P_1976_여행가자 {
	
	static int N,M,parents[];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int tra[] = new int[M];
		parents = new int [N];
		
		make();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int a = sc.nextInt();
				if(a==1) {
					union(i,j);
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			tra[i] = sc.nextInt()-1;
		}
        boolean check = false;
      
        for(int i=0; i<M-1; i++) {
        	int checking = find(tra[i]);
            if(checking != find(tra[i+1])) {
                check = true; 
                break;
            }
        }
        if(check)
            System.out.println("NO");
        else
            System.out.println("YES");
	}
	private static void make() {
		
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}