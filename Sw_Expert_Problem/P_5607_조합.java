package com.ssafy;

import java.util.Scanner;

public class P_5607_조합 {
	
	static int N,R;
	static int Q = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test = 1; test <= T; test++) {
			
			N = sc.nextInt();
			R = sc.nextInt();
			
			System.out.println("#"+test+" "+nCr(N,R,Q));
			
			
		}
		

	}
	private static long nCr(int n, int r, int p) {
		if(r==0) return 1L;
			
		long fac[] = new long[n+1];
		fac[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i-1]*i%p;
		}
		
		 return (fac[n]* power(fac[r], p-2,p ) 
	                % p * power(fac[n-r], p-2,p) 
	                                    % p) % p; 
		
	}
	
	static long power(long x, long y, long p)  { 
		long res = 1L; 
        x = x % p; 
        //=> 3^7 > 7 3 1   3^7 --> 3^1*3^2*3^4             
        while (y > 0) {    
            if (y % 2 == 1) 
                res = (res * x) % p; 
            y = y >> 1; // y = y/2 
            x = (x * x) % p; 
        }  
        return res; 
    }

}
