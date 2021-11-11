package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P_17142_연구소3 {
	
	static class virus{
		int r;
		int c;
		public virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N;
	static int M;
	static int arr[][];
	static List<virus> list;
	static int[] v ;
	static int vcount=0;
	static int vc = 0;
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int arrc[][];
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList<>();
		arr = new int[N][N];
		arrc = new int[N][N];
		v = new int[M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==2) {
					list.add(new virus(i,j));
				}
				if(arr[i][j]==0) {
					vcount ++;
				}
			}
		}

		
		comb(0,0);
		if(vcount==0) {
			System.out.println(0);
		}else {
			if(answer==Integer.MAX_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(answer);
			}
		}


	}
	private static void comb(int cnt, int start) {
		
		if(cnt==M) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arrc[i][j] = arr[i][j];
				}
			}
			answer = Math.min(answer,bfs(v)) ;
			return;
		}
		for (int i = start; i < list.size(); i++) {
			v[cnt] = i;
			comb(cnt+1, i+1);
		}
		
		
	}
	private static int bfs(int [] vi) {
		int vc = 0;
		boolean vis[][] = new boolean[N][N];
		Queue<Integer> queue = new LinkedList<Integer>();
		//뽑은 바이러스를 큐에 넣는다.
		for (int i = 0; i < vi.length; i++) {
			queue.add(list.get(v[i]).r);
			queue.add(list.get(v[i]).c);
			vis[list.get(v[i]).r][list.get(v[i]).c] = true;
		}
		int time = 0;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int i = 0; i < size/2; i++) {
				int ci = queue.poll();
				int cj = queue.poll();
				
				for (int j = 0; j < 4; j++) {
					int ni = ci + dy[j];
					int nj = cj + dx[j];
					
					if(ni<0||nj<0||ni>=N||nj>=N||vis[ni][nj]||arrc[ni][nj]==1) continue;
					
					queue.add(ni);
					queue.add(nj);
					vis[ni][nj] = true;
					if(arrc[ni][nj]==0) {
						vc++;
					}
					arrc[ni][nj] = -1;
				}
				
			}
			time++;
			if(vc==vcount) {
				return time;
			}
		}
		return Integer.MAX_VALUE;

	}

}
