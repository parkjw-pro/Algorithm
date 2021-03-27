package com.ssafy;

import java.util.Scanner;

public class P_1052_물병 {
	
	static int answer = 0;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		K = sc.nextInt();
		
		while(true) {
			if(divide(N+answer)<=K) {
				break;
			}else {
				answer++;
			}
			
		}
		System.out.println(answer);

	}
	private static int divide(int n) {
		int add = 0;
		while(n>0) {
			if(n%2==1) {
				add++;
			}
			n = n/2;
		}
		return add;

		
	}

}
