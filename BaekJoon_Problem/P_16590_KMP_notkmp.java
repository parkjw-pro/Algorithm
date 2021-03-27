//package com.ssafy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class P_16590_KMP_notkmp {
//
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		Scanner sc = new Scanner(System.in);
//		
//		int N = Integer.parseInt(st.nextToken());
//		int Q = Integer.parseInt(st.nextToken());
//		ArrayList<Integer>arr[] = new ArrayList[N];
//		
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = new ArrayList<Integer>();
//		}
//				
//
//		for (int i = 0; i < N; i++) {
//			
//			String s = br.readLine();
//			for (int j = 0; j < s.length(); j++) {
//				if(s.charAt(j)<97&&s.charAt(j)!=32) {
//					arr.add((int) s.charAt(j));
//				}
//			}
//		}
//		System.out.println(arr.size());
//		for (int i = 0; i < Q; i++) {
//			String s = br.readLine();
//			ArrayList<Integer> arr2 = new ArrayList<Integer>();
//			
//			for (int j = 0; j < arr.size(); j++) {
//				arr2.add(arr.get(j));
//			}
//			
//			for (int j = 0; j < s.length(); j++) {
//				boolean flag = false;
//				for (int j2 = 0; j2 < arr2.size(); j2++) {
//					if((int) s.charAt(j)==arr2.get(j2)) {
//						arr2.remove(j2);
//						//System.out.println(arr2.toString());
//						flag = true;
//						break;
//					}
//				}
//				if(!flag) {
//					System.out.println("NO");
//					break;
//					}
//				if(j==s.length()-1) {
//					System.out.println("YES");
//				}
//			}
//		}
//	}
//}