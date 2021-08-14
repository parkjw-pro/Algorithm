package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P_1920_수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			map.put(n, 1);
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(map.get(n) != null) {
				bw.write("1\n");
			}else {
				bw.write("0\n");
			}

			
			
		}
		bw.flush();
		bw.close();
		

	}

}
