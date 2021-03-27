package com.ssafy;


import java.util.Scanner;

public class P_13977_이항계수와쿼리 {
	
	static int N,R;
	static int Q = 1000000007;
	static long fac[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		fac = new long[1000001];
		fac[0] = 1;

		int max = 0;
		for (int test = 1; test <= T; test++) {
			
			N = sc.nextInt();
			R = sc.nextInt();
			
			if(N>max) {
				for (int i = max+1; i <= N; i++) {
					fac[i] = fac[i-1]*i%Q;
				}
				max = N;
			}
			
			System.out.println(nCr(N,R,Q));
			
			
		}
		

	}
	private static long nCr(int n, int r, int p) {
		if(r==0) return 1L;
			

		
		 return (fac[n]* power(fac[r], p-2,p ) 
	                % p * power(fac[n-r], p-2,p) 
	                                    % p) % p; 
		
	}
	
	static long power(long x, long y, long p)  { 
		long res = 1L; 
        x = x % p;       
        while (y > 0) {    
            if (y % 2 == 1) 
                res = (res * x) % p; 
            y = y >> 1;
            x = (x * x) % p; 
        }  
        return res; 
    }

}
