package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1120_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		int answer = 0;
		
		for (int i = 0; i <= s2.length()-s1.length(); i++) {
			int count = 0;
			for (int j = 0; j < s1.length(); j++) {
				
				if(s2.charAt(i+j)==s1.charAt(j)) {
					count++;
				}
			}
			answer = Math.max(count, answer);
		}
		answer = s1.length()-answer;
		System.out.println(answer);

	}

}
