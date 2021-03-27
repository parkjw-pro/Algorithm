package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_16236_아기상어 {
	
	static class shark{
		
		int i;
		int j;
		int size;
		
		public shark(int i, int j, int size) {
			super();
			this.i = i;
			this.j = j;
			this.size = size;
		}
	}
	static int N,map[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,-1,0,1};
	static boolean vis[][]; 
	static Queue<shark> sq = new LinkedList<shark>();
	static int count2=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==9) {
					sq.offer(new shark(i,j,20));
					map[i][j] = 0;
				}
			}
		}
		bfs();
		System.out.println();
		System.out.println(count2);
		
	}
	
	
	private static void bfs() {
		Queue<Integer> cq = new LinkedList<Integer>();
		cq.offer(0);
		
		
		while(!sq.isEmpty()) {
			
			vis = new boolean[N][N];
			int size = sq.size();
			boolean eat = false;
			System.out.println("=====");
			for (int t = 0; t < size; t++) {
				
				shark s = sq.poll();
				int count = cq.poll();
				
				
				for (int i = 0; i < 4; i++) {
					
					int ny = s.i+dy[i];
					int nx = s.j+dx[i];
					
					if(ny<0||nx<0||ny>=N||nx>=N||map[ny][nx]>s.size/10) continue;
					
					if(!vis[ny][nx]&&map[ny][nx]==0||map[ny][nx]==sq.size()/10) {
						vis[ny][nx] = true;
						System.out.println(1);
						System.out.println(ny+" "+nx);
						sq.offer(new shark(ny,nx,sq.size()));
						cq.offer(count+1);
						continue;
					}
					if(vis[ny][nx]) continue;
					vis[ny][nx] = true;
					map[ny][nx] = 0;
					int a  = sq.size()+1;
					int k = a- (a/10)*10;
					if(k==sq.size()/10) {
						a = (a/10)*10 + 10;
					}
					sq.offer(new shark(ny,nx,a));
					cq.offer(count+1);
					count2 = count+1;
					eat = true;
					break;
				}
				if(eat) {
					while(sq.size()==2) {
						sq.poll();
					}
					break;
				}
			}
			
		//	if(vis[0][0]||vis[0][N-1]||vis[N-1][0]||vis[N-1][N-1]) break;
			boolean flag = false;
			shark s2 = sq.peek();
			
			if(sq.size()>50) {
				return;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]!=0||map[i][j]<s2.size/10) {
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			if(!flag) return;
		}
	}
}