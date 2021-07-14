package com.ssafy;

import java.util.Scanner;

public class P_1188_음식평론가 {
	
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int count = 0;
		while(N!=M) {
			if(N>M) {
				N = N - M;
			}else {
				M = M - N;
				count = count + N;
			}
		}
		
		System.out.println(count);
		
		

	}

}
