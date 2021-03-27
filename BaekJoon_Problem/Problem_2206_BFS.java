package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2206_BFS {

	// 변수 및 배열 생성
	static int N,M;
	static char map[][];
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static boolean visited[][];
	static boolean visited2[][];
	static int count1 = 0;
	static int MIN = 10000000;
	static int c = 1;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][M];
		visited = new boolean[N][M];
		visited2 = new boolean[N][M];
		sc.nextLine();

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);//입력받은 해당 라인의 j인덱스를 배열에 삽입
			}
		}
		bfs();//완전 탐색을 실행하는데, 깊이탐색을 이용한다.

		if(MIN==10000000) {
			System.out.println(-1);
		}else {
		System.out.println(MIN);	
		}
	}
	
	//깊이 탐색을 통해  끝까지 갔을때의 1이 나온 갯수의 최소값을 구한다.
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue_c = new LinkedList<Integer>();
		Queue<Integer> vaild = new LinkedList<Integer>();
		queue.offer(0);
		queue.offer(0);
		queue_c.offer(1);
		vaild.offer(1);
		visited[0][0]= true;
		visited2[0][0]= true;
		
		while(!queue.isEmpty()) {
			
			int ci = queue.poll();
			int cj = queue.poll();
			int count = queue_c.poll();
			int val = vaild.poll();
		
			if(ci==N-1&&cj==M-1) {
				if(count<MIN) {
					MIN = count;
					return;
				}
			}
			for (int k = 0; k < 4; k++) {
				int ny = ci + dy[k];
				int nx = cj + dx[k];
			
				if(val==1) {
					if(ny>=0&&nx>=0&&ny<N&&nx<M&&!visited[ny][nx]) {
						if(map[ny][nx]=='1') {	
							visited2[ny][nx] = true;
							visited[ny][nx] = true;
							queue.offer(ny);
							queue.offer(nx);
							queue_c.offer(count+1);
							vaild.offer(0);

						}else {
							visited[ny][nx] = true;
							visited2[ny][nx] = true;
							queue.offer(ny);
							queue.offer(nx);
							queue_c.offer(count+1);
							vaild.offer(val);
						}
					}
				}
				else {
					if(ny>=0&&nx>=0&&ny<N&&nx<M&&!visited2[ny][nx]&&!visited[ny][nx]) {
						if(map[ny][nx]=='1') {
							continue;
						}else {
//							visited[ny][nx] = true;
							visited2[ny][nx] = true;
							queue.offer(ny);
							queue.offer(nx);
							queue_c.offer(count+1);
							vaild.offer(val);
						}
					}
				}
			}
		}
	}
}