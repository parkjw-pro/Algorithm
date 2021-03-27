package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> hashmap = new HashMap<String, String>();
		ArrayList<String> s = new ArrayList<String>();
		
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			if(!hashmap.containsKey(str)) {
				hashmap.put(str, "nohear");
			}
		}
		for (int i = 0; i < M; i++) {
			String str = in.readLine();
			if(!hashmap.containsKey(str)) {
				hashmap.put(str, "nosee");
			}else {
				s.add(str);
			}
		}
		
		Collections.sort(s);
		
		System.out.println(s.size());
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
		}
	}
}
