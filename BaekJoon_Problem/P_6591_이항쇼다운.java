package com.ssafy;

import java.util.Scanner;

public class P_6591_이항쇼다운 {
	
	static int n,k;
	static int count = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			count = 0;
			n = sc.nextInt();
			k = sc.nextInt();
			if(n==0&&k==0) break;
			
			//comb(0,0);
			
	        int div = 1;
	        long ans = 1;
	 
	 
	        if (n - k < k) {
	            k = n - k;
	        }
	 
	        while (k-- > 0) {
	            ans *= n--;
	            ans /= div++;
	        }

			System.out.println(ans);
		}
	}
//	private static void comb(int start, int cnt) {
//		
//		if(cnt==k) {
//			count++;
//			return;
//		}
//		for (int i = start; i < n; i++) {
//			comb(i+1,cnt+1);
//		}
//	}
}