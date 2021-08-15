package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P_13711_LCS4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			hm.put(Integer.parseInt(st.nextToken()), i);
		}
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)	{
			arr[i] = hm.get(Integer.parseInt(st.nextToken()));
		}
		
		int LIS[] = new int[N];
		int size = 0; //lis 길이
		
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);//arr[i] : 탐색 키 
           //-> 찾으면 인덱스, 못찾으면 음수값으로 자신이 삽입될 위치. -> -삽입위치-1을 반환
			
			//중복값이 없으면 temp는 음수값이다.
		//	System.out.println(Math.abs(temp));
			if(temp<0) {
			temp = Math.abs(temp)-1;//삽입위치 환산
			}
			LIS[temp] = arr[i];
			
			if(temp == size) { // 맨뒤에 추가하는 상황
				++size;
			}
		}
		System.out.println(size);


		
		
	}
}
