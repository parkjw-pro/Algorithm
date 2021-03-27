package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2493_low {

	public static void main(String[] args) throws  IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		int N = Integer.parseInt(bf.readLine());

		int top[] = new int[N];
		st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++) {
			top[i]=  Integer.parseInt(st.nextToken());

		}
		
		for (int i = N-1; i >0; i--) {
			boolean exist = false;
			
			for (int j = i-1; j >=0; j--) {
				
				if(top[j]>top[i]) {
					top[i] = j+1;
					exist = true;
					break;
				}
			}
			if(!exist) { top[i] = 0;}
		}
		top[0] = 0;
		
		for (int i = 0; i < top.length; i++) {
			bw.write(top[i]+" ");
		}
		bw.close();
	}
}