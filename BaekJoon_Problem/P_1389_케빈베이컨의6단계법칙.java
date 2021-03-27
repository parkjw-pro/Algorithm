package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		int M =sc.nextInt();
		ArrayList<Integer> arr[] = new ArrayList[N];
		
		
    //가장 멀리 연결되어있는 친구의 최소값 을 가지는 점을 출력.
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			arr[from-1].add(to-1);
			arr[to-1].add(from-1);
		}
		int answer = 0;
		int resultsum = Integer.MAX_VALUE;
		int INFINITY = Integer.MAX_VALUE;
		
		for (int k = 0; k < N; k++) {
			
			boolean vis[] = new boolean[N];
			int start = k;
			int minEdge[] = new int[N];
			
			Arrays.fill(minEdge, INFINITY);
			minEdge[start] = 0;
			int current = 0;
			int min = 0;
			
			
			
			for (int i = 0; i < N; i++) {
				min = INFINITY;
				for (int j = 0; j < N; j++) {
					if(!vis[j]&&min>minEdge[j]) {
						min = minEdge[j];
						current = j;
						}
				}
				vis[current] = true;
			//	System.out.println(min);
				for (int a : arr[current]) {
					if(!vis[a]&&minEdge[a] > min + 1) {
						minEdge[a] = min +1;
					}
				}
			}
			int sum = 0;
			for (int a  : minEdge) {
			//	System.out.println(sum);
				sum = sum + a;
			}
			
			if(sum<resultsum) {
				resultsum = sum;
				answer = k;
			}
		}
		System.out.println(answer+1);
	}
}
