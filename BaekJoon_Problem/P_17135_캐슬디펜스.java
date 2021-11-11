package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_17135_캐슬디펜스 {
	
	static int N;
	static int M;
	static int arr[][];
	static int D;
	static int a[] = new int[3];
	static int answer = 0;
	static int temp[][];
	static int arrc[][];
	static int dy[] = {-1,0,0};
	static int dx[] = {0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		arr = new int[N][M];
		arrc = new int[N][M];
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		comb(0,0);
		System.out.println(answer);

	}
	private static void comb(int cnt, int start) {
		
		
		if(cnt==3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arrc[i][j] = arr[i][j];
				}
			}
			answer = Math.max(answer, run(a));
			return;
		}
		
		for (int i = start; i < M; i++) {
			a[cnt] = i;
			comb(cnt+1, i+1);
		}
		
	}
	private static int run(int [] sniper) {
		int count = 0;
		//3명의 스나이퍼 배일이 주어졌다.
		//스나이퍼가 적중하면 +1하는게 아니라 적이 사라지는 카운트를 보고 +1 한다.
		
		
		//한칸씩 성으로 전진
		for (int k = N-1; k >=0; k--) {
			temp = new int[N][M];
			//모든 궁수가 동시에 공격
			//(k,i)가 기준거리 1이다.
			for (int s = 0; s < 3; s++) {
				
				//궁수마다 bfs를 통해 가장 가까이있는 적 사살 죽이면 + 하는게 아니라 체크만한다음, 
				bfs(sniper[s],k);
			
				
				
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arrc[i][j]==1&&temp[i][j]==1) {
						arrc[i][j] = 0;
						count++;
					}
				}
			}
			
			
			
			
		}
		return count ;
	}
	private static void bfs(int c, int R) {
		boolean vis[][] = new boolean[N][M];
		if(arrc[R][c]==1) {
			temp[R][c] = 1;
			return;
		}
		if(D==1) {
			return;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(R);
		queue.add(c);
		vis[R][c] = true;
		int time = 1;
		int si = 0;
		int sj = Integer.MAX_VALUE;
		boolean find = false;
		while(!queue.isEmpty()) {
			if(time>=D) {
				return;
			}
			
			int size = queue.size();
			for (int i = 0; i < size/2; i++) {
				
				int ni = queue.poll();
				int nj = queue.poll();
				
				for (int j = 0; j < 3; j++) {
					
					int nr = ni + dy[j];
					int nc = nj + dx[j];
					
					if(nr<0||nc<0||nr>R||nc>=M||vis[nr][nc]) continue;
					
					if(arrc[nr][nc]==1) {
						if(sj>nc) {
							si = nr;
							sj = nc;
							queue.add(nr);
							queue.add(nc);
							vis[nr][nc] = true;
							find = true;
						}
					}else {
						queue.add(nr);
						queue.add(nc);
						vis[nr][nc] = true;
					}
					
				}
				
			}
			time++;
			if(find) {
				temp[si][sj] = 1;
				return;
			}
			
		}
		return;
		
		
		
	}

}
