package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_3020_개똥벌레 {
	
	static int N;
	static int H;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer input = new StringTokenizer(br.readLine());

		N = Integer.parseInt(input.nextToken()); 
		H = Integer.parseInt(input.nextToken());
		int answer = Integer.MAX_VALUE;
		int answer_count = 0;
		
		int under[] = new int[H+1]; 
		int upper[] = new int[H+1];

		int n ;
		for (int i = 0; i < N/2; i++) {
			n = Integer.parseInt(br.readLine());
			under[n]++;
			n = Integer.parseInt(br.readLine());
			upper[n]++;
		}
		
		
		//높이가 n 짜리가 들어오면 배열[n] 에 1을 더함
		
		
		for (int i = H-1; i > 0; i--) {
			under[i] = under[i] + under[i+1];
			
			//높이가 9인 석순의 갯수는 높이가 8인 석순의 갯수에 더해져야 한다.
			
			
			
			upper[i] = upper[i] + upper[i+1];
		}
		
		
		
		
		
		
		for (int i = 1; i <= H; i++) {
			int count = under[i] + upper[H-i+1];
			if(count==answer) {
				answer_count++;
			}
			if(count<answer) {
				answer = count;
				answer_count = 1;
			}
		}
		System.out.println(answer+" "+answer_count);
	}
	
}
