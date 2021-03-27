package com.ssafy;

import java.util.Scanner;

public class P_2869_달팽이는올라가고싶다 {
	
	static int A,B,V;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		V = sc.nextInt();
		//V = V-A;
		if((V-A)%(A-B)==0) {
			System.out.println((V-A)/(A-B)+1);
		}else {
		System.out.println(((V-A)/(A-B)+2));
		}
	}
}