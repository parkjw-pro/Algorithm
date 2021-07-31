package com.ssafy;

import java.util.Scanner;

public class P_1958_LCS3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String s3 = sc.nextLine();
		
		int dp[][][] = new int[s1.length()+1][s2.length()+1][s3.length()+1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				for (int k = 1; k <= s3.length(); k++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)&&s2.charAt(j-1)==s3.charAt(k-1)) {
					dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
				}else {
					int n = Math.max(dp[i-1][j][k], dp[i][j-1][k]);
					n = Math.max(n, dp[i][j][k-1]);
					dp[i][j][k] = n;
				}
				}
			}
		}
		System.out.println(dp[s1.length()][s2.length()][s3.length()]);
	}
}
