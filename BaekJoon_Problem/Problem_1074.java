package com.ssafy;

import java.util.Scanner;

public class Problem_1074 {
	
    static int N,r,c;
    static int len; 
    static int size;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		len = (int) Math.pow(2, N);
		size = len* len;

		r = sc.nextInt();
		c = sc.nextInt();
	
		letz(r,c,0,len);
		sc.close();
	}
	public static void letz(int y, int x, int count, int len) {
		
		if(len==1) {System.out.println(count); return;}

		if(y<len/2&&x<len/2) {
			letz(y, x, count, len/2);
		}
		if(y<len/2&&x>=len/2) {
			letz(y, x-len/2, count+len*len/4, len/2);
		}
		if(y>=len/2&&x<len/2) {
			letz(y-len/2, x, count+len*len/4*2, len/2);
		}
		if(y>=len/2&&x>=len/2) {
			letz(y-len/2, x-len/2, count+len*len/4*3, len/2);
		}
	}
}