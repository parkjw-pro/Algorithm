package com.ssafy;

import java.util.Scanner;

public class P_1003_피보나치 {
	
	static int N,arr[],memo[];
	static int arr0[],arr1[];
	static int count0 = 0;
	static int count1 = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		arr0 = new int[N+1];
		arr1 = new int[N+1];
	    memo = new int[N+1];
		memo[0] = 0;
		memo[1] = 1;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int j = 0; j < N; j++) {
			count0 = 0;
			count1 = 0;
			fibo(j);

			System.out.println(count0+" "+count1);
			
		}
		

	}
	private static int fibo(int a) {
		if(a==0) count0++;
		if(a==1) count1++;
		
		if(a>=2&&memo[a]==0) {
			memo[a] =  fibo(a-1) + fibo(a-2);
		}
		return  memo[a];
	}

}
