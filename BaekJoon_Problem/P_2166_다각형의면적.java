package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2166_다각형의면적 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	     int N = Integer.parseInt(br.readLine());
	     long[] x = new long[N + 1];
	     long[] y = new long[N + 1];
	     long suma = 0, sumb = 0;

	     for (int i = 0; i < N; i++) {
	    	 StringTokenizer st = new StringTokenizer(br.readLine());
	    	 x[i] = Integer.parseInt(st.nextToken());
	    	 y[i] = Integer.parseInt(st.nextToken());
	     }
	     x[N] = x[0];
	     
	     y[N] = y[0];

	     for (int i = 0; i < N; i++) {
	    	 suma += x[i] * y[i + 1];
	    	 sumb += x[i + 1] * y[i];
	     }
	     
	     double answer = Math.abs(suma - sumb) / 2.0;
	     
	     System.out.println(String.format("%.1f", answer));
	}

}
