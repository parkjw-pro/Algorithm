package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_3163_떨어지는개미 {
	
	
	// 결국 개미가 선상에 n개가 있고,  오른쪽 방향이 a개, 왼쪾 방향이 b개일때, ( a+b = n)
	// 모든 충돌 후 최종적으로 오른쪽으로 떨어지는 개미는 a개이고 왼쪽으로 떨어지는 개미는 b개라는 점을 이해했다.
	// 이 원리가 이해가 갔다면 시뮬레이션을 하지 않고  정렬만을 이용해서 문제해결 가능 -> 정렬만쓰니 NlongN의 시간 복잡도겠지.
	
	//이제 떨어지는 순서만 구하면 된다. 
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int test = 1; test <= T; test++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N+1][2];
			arr[N][0] = Integer.MAX_VALUE;
			int idarr[] = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				int start = Integer.parseInt(st.nextToken());
				int id = Integer.parseInt(st.nextToken());
				idarr[i] = id;
				
				if(id<0) {
					arr[i][0] = start+1;
					arr[i][1] = id;//왼쪽으로 가는 개미
				}else{
					arr[i][0] = L-start+1;
					arr[i][1] = id;//오른쪽으로 가는 개미.
				}
			}
			
			//정렬을 해주는 이유 : 거리가 짧은게 먼저 떨어짐.
			Arrays.sort(arr,Comparator.comparing(o1 -> o1[0]));
			
			int leftarr[] = new int[K];
			int rightarr[] = new int[K];
			for (int i = 0; i < K; i++) {
				leftarr[i] = idarr[i];
				rightarr[i] = idarr[N-1-i];
			}
			int l =0;
			int r = 0;
			int answer[] = new int[K];
			for (int i = 0; i < K; i++) {		
				if(arr[i][1]<0) {
					if(arr[i][0]!=arr[i+1][0]) {
						answer[i] = leftarr[l];
						l++;
					}else {
						if(leftarr[l]<rightarr[r]) {
							answer[i] = leftarr[l];
							l++;
						}else {
							answer[i] = rightarr[r];
							r++;
							arr[i+1][1] = arr[i][1];
						}
					}
				}
				else {
					if(arr[i][0]!=arr[i+1][0]) {
						answer[i] = rightarr[r];
						r++;
					}else {
						if(leftarr[l]>rightarr[r]) {
							answer[i] = rightarr[r];
							r++;
						}else {
							answer[i] = leftarr[l];
							l++;
							arr[i+1][1] = arr[i][1];
						}
					}
				}
			}
			
			//k번째 까지 떨어지는 개미 출력.(순서대로 출력됨)
//			for (int i = 0; i < answer.length; i++) {
//		
//				System.out.print(answer[i]+" ");	
//			}
			System.out.println(answer[K-1]);
		}
	}
}