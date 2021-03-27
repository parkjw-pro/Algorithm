package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_7569 {
	static Queue<Integer> queue = new LinkedList<Integer>();
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N,M,map[][][];
		M = sc.nextInt();
		N = sc.nextInt();
		int H = sc.nextInt();
		map = new int[H][N][M];
		int K = 6;

		int dt[] = {0,0,0,0,1,-1};
		int dy[] ={-1,0,1,0,0,0};
		int dx[] = {0,1,0,-1,0,0};
		
		if(H==1) {K=4;}
		
		for (int t = 0; t < H; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[t][i][j]= sc.nextInt();
					if(map[t][i][j]==1) {
						queue.offer(t);
						queue.offer(i);
						queue.offer(j);
					}
				}
			}
			
		}

		int current_t;
		int current_i;
		int current_j;
		int count = -1;// 무조건 한번은 실행되니 -1로 초기화.
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size/3; i++) {
				current_t = queue.poll();
				current_i = queue.poll();
				current_j = queue.poll();
				
				for (int j = 0; j <K ; j++) {
					int nt = current_t+dt[j];
					int ny = current_i+dy[j];
					int nx = current_j+dx[j];
					
					if(nt>=0&&ny>=0&&nx>=0&&nt<H&&ny<N&&nx<M&&map[nt][ny][nx]==0){
						map[nt][ny][nx] = 1;
						queue.offer(nt);
						queue.offer(ny);
						queue.offer(nx);
					}
				}
			}
			count++;
			
		}
		for (int t = 0; t < H; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[t][i][j]==0) {
						count = -1;//안익은 토마토있으면 count를 -1로 초기화
						break;
				
					}
				}
			}
		}
		System.out.println(count);
	}
}