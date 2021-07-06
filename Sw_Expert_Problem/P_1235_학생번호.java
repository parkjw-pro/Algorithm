package com.ssafy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P_1235_학생번호 {
	
	static int N;
	static String arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		int n = 1;// n은 비교할 자릿수
		while(true) {
			boolean flag = false;

			//해당 자릿수의 숫자를 해쉬맵에 넣으며 중복값이 있는지 체크한다.
			HashMap<String,String> map1 = new HashMap<String,String>();
			for (int i = 0; i < N; i++) {
				String a = arr[i].substring(arr[i].length()-n);
				
				if(map1.containsKey(a)) {
					flag = true;
					break;
				}
				
				map1.put(a,a);

			}
			if(!flag) {
				System.out.println(n);
				break;
			}else {
				n++;
			}
		}
		
	}

}
