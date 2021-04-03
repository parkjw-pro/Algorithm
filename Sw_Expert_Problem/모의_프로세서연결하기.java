package com.ssafy;

import java.util.Scanner;

public class 모의_프로세서연결하기 {
	
	static class pros{
		
		int i;
		int j;
		
		public pros(int i, int j) {
			
			super();
			this.i = i;
			this.j = j;
		}
	}
	static int N,map[][];
	static int answer;
	static pros p[];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static boolean vis[][];
	static int manycon;

	public static void main(String[] args) {
		
		//알고리즘 구상
		// 가장 많이 프로세서를 연결하면서, 연결된 숫자가 가장 큰 경우의 수가 여러가지일 경우
		// 가장 짧은 전선을 나타내는 최적의 해 구하기
		// 하나의 프로세서를 연결할 수있는 경우의수는 4방향 
		// 여기서 전선이 중복되는 걸 빼고 가장 많은 프로세서가 연결되면서 그 전선의 길이가 가장 짧은 해 찾기.
		// dfs기법으로 풀면 될듯! 포문 4번 돌리고 하나 연결하고 다음꺼 연결하고 체크배열 통과 못하면 다시 리턴하고 해보자!
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			
			answer = Integer.MAX_VALUE;
			N = sc.nextInt();
			p = new pros[N];
			map = new int[N][N];
			vis = new boolean[N][N];
			manycon = 0;
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]==1) {
						p[cnt++] = new pros(i,j);
						vis[i][j] = true;
					}
				}
			}
			
			dfs(0,0,0);
			
			System.out.println("#"+test+" "+answer);
		}
	}
	private static void dfs(int cnt, int s, int connect) {
		
		if(cnt==N) {
			
			if(connect>manycon) {
				
				manycon = connect;
				answer = s;
				return;
			}else if(connect==manycon) {
				
				answer = Math.min(answer,s);
				return;
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			
			int c = 0;//전선의 길이.
			boolean flag = true;
			
			
			int ny = p[cnt].i + dy[i];
			int nx = p[cnt].j + dx[i];
			
			if(ny<0||nx<0||ny>=N||nx>=N) {
				dfs(cnt+1,s,connect+1);
				return;
			}
			
			if(vis[ny][nx]) continue;

			if(dy[i]!=0) {
				
				int k = ny;
				while(k>=0&&k<N) {
					if(vis[k][p[cnt].j]) {flag = false; break;}
					k = k+ dy[i];
				}
				k = ny;
				
				//vis처리해줌
				while(flag&&k>=0&&k<N) {
					
					vis[k][p[cnt].j]= true;
					k = k+ dy[i];
					c = c+1;
				}
				
				
			}
			if(dx[i]!=0) {
				int k = nx;
				while(k>=0&&k<N) {
					if(vis[p[cnt].i][k]) {flag = false; break;}
					k = k+ dx[i];
				}
				k = nx;
				while(flag&&k>=0&&k<N) {
					vis[p[cnt].i][k]  = true;
					k = k+ dx[i];
					c = c+1;
				}
			}
			
			if(flag) {

				dfs(cnt+1,s+c,connect+1);
				if(dy[i]!=0) {
					int k = ny;
					while(k>=0&&k<N) {
						vis[k][p[cnt].j]= false;
						k = k + dy[i];
					}
				}
				if(dx[i]!=0) {
					int k = nx;
					while(k>=0&&k<N) {
						vis[p[cnt].i][k]  = false;
						k = k + dx[i];
					}
				}
			}
			else dfs(cnt+1,s,connect);
		}
	}
}

