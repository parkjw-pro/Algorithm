package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_16234_인구이동 {
	
	static int N;
	static int L;
	static int R;
	static int arr[][][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static boolean vis[][];
	static int count;
	static boolean flag;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][N][2];
		vis = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j][0] = sc.nextInt();
			}
		}
		//인구차이마다 국경을 열어 하나로 묶는 bfs실시
		// 연합국 고유의 값은 3번째 1번 인덱스에 저장한다.
		// for문이 끝난후 연합국들끼리 정리한번해주고
		//하루끝난다.
		flag = true;
		int answer = 0;
		while(flag) {
			flag = false;
			count = 1;
			vis = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!vis[i][j]) {
						//해당 연합의 평균인구수
						int p = bfs(i,j);
						//평균인구수를 토대로 해당 연합국 모든 나라에 넣어준다.
						divide(i,j,p);
						

						count++;
					}
				}
			}
			if(flag) {
				answer ++;
			}
			
		}
		System.out.println(answer);
		

	}
	private static int bfs(int r, int c) {
		Queue<Integer> queue = new LinkedList<Integer>();
		vis[r][c] = true;
		queue.add(r);
		queue.add(c);
		arr[r][c][1] = count;
		int sum = arr[r][c][0];
		int cc = 1;
		
		while(!queue.isEmpty()) {
			int ci = queue.poll();
			int cj = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int ni = ci + dy[i];
				int nj = cj + dx[i];
				if(ni<0||nj<0||ni>=N||nj>=N||vis[ni][nj]) continue;
				
				int a = Math.abs(arr[ci][cj][0]-arr[ni][nj][0]);
				
				if(a>=L&&a<=R){
					//연합에 속한다.
					arr[ni][nj][1] = count;
					queue.add(ni);
					queue.add(nj);
					sum = sum+ arr[ni][nj][0];
					cc++;
					vis[ni][nj] = true;
				}
			}
		}
		return sum/cc;
	}
	private static void divide(int r, int c, int p) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean vis2[][] = new boolean[N][N]; 
		vis[r][c] = true;
		queue.add(r);
		queue.add(c);
		vis2[r][c] = true;
		arr[r][c][1] = 0;
		if(arr[r][c][0]!=p) {
			arr[r][c][0] = p;
			flag = true;
		}
		
		while(!queue.isEmpty()) {
			int ci = queue.poll();
			int cj = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int ni = ci + dy[i];
				int nj = cj + dx[i];
				if(ni<0||nj<0||ni>=N||nj>=N||vis2[ni][nj]||arr[ni][nj][1]!=count) continue;
				queue.add(ni);
				queue.add(nj);
				vis2[ni][nj] = true;
				arr[ni][nj][1]=0;
				if(arr[ni][nj][0]!=p) {
					arr[ni][nj][0] = p;
					flag = true;
				}
			}
		}
		
	}

}
