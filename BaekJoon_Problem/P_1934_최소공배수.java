package com.ssafy;

import java.util.Scanner;

public class P_1934_최소공배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		int a[] = new int[T];
		int b[] = new int[T];
		
		for (int i = 0; i < T; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		
		for (int i = 0; i < T; i++) {
			int max = Math.max(a[i], b[i]);
			int min = Math.min(a[i], b[i]);
			
			int index = 1;
			while(true) {
				if((max*index)%min==0) {
					System.out.println(max*index);
					break;
				}else {
					index++;
				}
			}
		}
	}
}
