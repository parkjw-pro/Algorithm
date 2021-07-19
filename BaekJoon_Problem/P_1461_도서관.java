package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class P_1461_도서관 {
	
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int answer = 0;
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		//제일 마지막에 갈 M개 종료
		if(N<=M) {
			answer =Math.min(Math.abs(arr[0]), Math.abs(arr[arr.length-1]))*2 + Math.max(Math.abs(arr[0]), Math.abs(arr[arr.length-1]));
		}
		else if(Math.abs(arr[0])>Math.abs(arr[arr.length-1])) {
			answer = answer + Math.abs(arr[0]);
			int index = M;
			while(arr[index]<0) {
				answer = answer + Math.abs(arr[index]*2);
				index = index +M;
				if(index<0||index>=arr.length||arr[index]>0) {
					//answer = answer + arr[index -M+1]*2;
					break;
				}
			}
			index = arr.length-1;
			while(arr[index]>0) {
				answer = answer + arr[index]*2;
				index = index -M;
				if(index<0||index>=arr.length||arr[index]<0) {
					//answer = answer + arr[index +M-1]*2;
					break;
				}
			}
			
			
			
		}else {
			int index = arr.length-1;
			answer = answer + arr[index];
			index = index-M;
			while(arr[index]>0) {
				
				answer = answer + arr[index]*2;
				index = index -M;
				if(index<0||index>=arr.length||arr[index]<0) {
				//	answer = answer + arr[index +M-1]*2;
					break;
				}
			}
			index = 0;
			while(arr[index]<0) {
				
				answer = answer + Math.abs(arr[index]*2);
				index = index +M;
				if(index<0||index>=arr.length||arr[index]>0) {
					//answer = answer + arr[index -M+1]*2;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
