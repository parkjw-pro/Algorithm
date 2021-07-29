package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_2467_용액 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int n1= 0;;
		int n2 =0;;
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(arr, -arr[i]);
			//System.out.println(temp);
			if(temp<0) {
				if(-(temp+1)==0) {
					if(i==0) {
						n1 = arr[i];
						n2 = arr[i+1];
						break;
					}
					if(min>Math.abs(arr[i]+arr[-(temp+1)])) {
						n1 = arr[i];
						n2 = arr[-(temp+1)];
						min = Math.abs(arr[i]+arr[-(temp+1)]);
					}
				}else if(-(temp+1)==N) {
					if(i==N-1) {
						n1 = arr[i-1];
						n2 = arr[i];
						break;
					}
					if(min>Math.abs(arr[i]+arr[-(temp+2)])) {
						n1 = arr[i];
						n2 = arr[-(temp+2)];
						min = Math.abs(arr[i]+arr[-(temp+2)]);
					}
				}else {
					
					if(min>Math.abs(arr[i]+arr[-(temp+1)])&&i!=-(temp+1)) {
						n1 = arr[i];
						n2 = arr[-(temp+1)];
						min = Math.abs(arr[i]+arr[-(temp+1)]);
					}
					if(min>Math.abs(arr[i]+arr[-(temp+2)])&&i!=-(temp+2)) {
						n1 = arr[i];
						n2 = arr[-(temp+2)];
						min = Math.abs(arr[i]+arr[-(temp+2)]);
					}
				}

			}else {
				if(i!=temp) {
					n1 = arr[i];
					n2 = arr[temp];
					break;
				}

			}
		}
		if(n1<n2) {
			System.out.println(n1+" "+n2);
		}else {
			System.out.println(n2+" "+n1);
		}
		

	}

}
