package com.ssafy;

import java.util.Scanner;

public class Problem_2206 {

	// 변수 및 배열 생성
	static int N,M;
	static char map[][];
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static boolean visited[][];
	static int count1 = 0;
	static int MIN = 10000000;
	static int c = 1;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][M];
		visited = new boolean[N][M];
		sc.nextLine();

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);//입력받은 해당 라인의 j인덱스를 배열에 삽입
			}
		}
		dfs(0,0,0,1);//완전 탐색을 실행하는데, 깊이탐색을 이용한다.

		if(MIN==10000000) {
			System.out.println(-1);
		}else {
		System.out.println(MIN+1);	
		}
	}
	
	//깊이 탐색을 통해  끝까지 갔을때의 1이 나온 갯수의 최소값을 구한다.
	private static void dfs(int i, int j,int count, int vaild){

		visited[i][j] = true;
		
		if(i==N-1&&j==M-1) {
			if(count<MIN) {
				MIN = count;
				return;
			}
		}
		for (int k = 0; k < 4; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
		
			if(ny>=0&&nx>=0&&ny<N&&nx<M&&!visited[ny][nx]) {
				if(map[ny][nx]=='1') {
					if(vaild == 1) {
						dfs(ny,nx,count+1,0);
						//visited[ny][nx] = false;
					}else {
						continue;
					}
				}else {
					dfs(ny,nx,count+1,vaild);
					visited[ny][nx] = false;
				}
			}
		}
	}
}