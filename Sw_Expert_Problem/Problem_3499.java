package com.ssafy;
import java.util.Scanner;

public class Problem_3499 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			String str[] = new String[N];
			String str1[] = new String[N];
			
			for (int i = 0; i < N; i++) {
				str[i] = sc.next();
			}
			for (int i = 0; i < (double) N/2; i++) {
				str1[i*2] = str[i];
			}
			int k =0;
			for (int i = (N/2)+(N%2); i < N; i++) {
				str1[k*2+1] = str[i];
				k++;
			}
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < str1.length; i++) {
				System.out.print(str1[i]+" ");
			}
			System.out.println("");
		}
	}
}