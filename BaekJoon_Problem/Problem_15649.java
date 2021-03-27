package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_15649 {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N;
	static int M;
	static int answer[];
	static boolean vis[];
	
	static int input[];
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		

		StringTokenizer sb = new StringTokenizer(br.readLine());
		answer = new int[N];
		vis= new boolean[N];
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			
			input[i] = Integer.parseInt(sb.nextToken());
		}
		Arrays.sort(input);

		
		per(0,0);
		
		bw.close();
		
	}
	private static void per(int n, int k) throws IOException {
			
		if(n==M) {
			
			for (int i = 0; i < n; i++) {
				bw.write(answer[i]+" ");
				
			}
			bw.newLine();
			bw.flush();
			return;
		}
		boolean number_vis[] = new boolean[10001];
		for (int i = k; i < N; i++) {
			
			if(vis[i]||number_vis[input[i]]) continue;
			number_vis[input[i]] = true;
			answer[n] = input[i];
		//	vis[i] = true;
			
			per(n+1,i);
		//	vis[i] = false;
		}
	}
}
