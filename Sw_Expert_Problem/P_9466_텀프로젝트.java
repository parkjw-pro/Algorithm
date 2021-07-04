package com.ssafy;

import java.util.Scanner;

public class P_9466_텀프로젝트 {
	
	static int T,N;
	static int arr[];
	static boolean vis[];
	static boolean isDone[];//팀이 된 상태인지 체크
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			
			N = sc.nextInt();
			
			arr = new int[N];
			vis = new boolean[N];
			isDone = new boolean[N]; 
			answer = 0;
			
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				arr[j] = temp-1;
			}

			
			//팀이 되고 싶은데 이미 사이클이 형성된상태면 팀이 될 수 없다.
			
			for (int j = 0; j < N; j++) {
				
				if(!isDone[j]) {
					dfs(j);
				}
				
				
			}
			System.out.println(N-answer);
			
			
			
			
			
		}

	}
	private static void dfs(int num) {
		
		if(vis[num]) {
			isDone[num] = true;
			answer++;//팀이된 학생 수를 더한다.
		}else {
			vis[num] = true;
		}
		
		 int next =arr[num];
		
		if(!isDone[next]) {
			dfs(next);
		}
		
		vis[num] = false;
		isDone[num] = true;
		
	}

}
