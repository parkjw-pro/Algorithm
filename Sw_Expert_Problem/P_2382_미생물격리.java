package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_2382_미생물격리 {
	
	
	static class micro{
		
		int r;
		int c;
		int mc;
		int div;
		
		public micro(int r, int c, int mc, int div) {
			super();
			this.r = r;
			this.c = c;
			this.mc = mc;
			this.div = div;
		}
	}
	
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int arr[][][] = new int[N][N][3];
			Queue<micro> queue = new LinkedList<P_2382_미생물격리.micro>();
			//0번째거가 총 갯수, 1번째가 진행방향, 2번째가 최대갯수
			
			for (int k = 0; k < K; k++) {
				
				//각각 미생물 군집에 대한 입력
				int r = sc.nextInt();
				int c = sc.nextInt();
				int mc = sc.nextInt();
				int div = sc.nextInt()-1;
				
				
				
				queue.add(new micro(r,c,mc,div));
			}
			int n = 0;
			int answer = 0;
			
			while(n<M) {
				answer = 0;
				//미생물 군집을 이동시킨다.
				int size = queue.size();
				
				for (int i = 0; i < size; i++) {
					micro m = queue.poll();
					
					int r = m.r + dy[m.div];
					int c = m.c + dx[m.div];
					
					//약품에 칠해진 셀에 도착했을경우
					if(r==0||c==0||r==N-1||c==N-1) {
						
						if(m.mc/2==0) {
							continue;
						}
						answer+=m.mc/2;
						if(m.div==0) {
							queue.add(new micro(r,c,m.mc/2,1));
						}else if(m.div==1) {
							queue.add(new micro(r,c,m.mc/2,0));
						}else if(m.div==2) {
							queue.add(new micro(r,c,m.mc/2,3));
						}else if(m.div==3) {
							queue.add(new micro(r,c,m.mc/2,2));
						}
						continue;
					}
					//0번째거가 총 갯수, 1번째가 진행방향, 2번째가 최대갯수
					
					//미생물을 이동시킴
					arr[r][c][0]+=m.mc;
					if(arr[r][c][2]<m.mc) {
						arr[r][c][2] = m.mc;
						arr[r][c][1] = m.div;
					}

					
				}
				for (int i = 1; i < N-1; i++) {
					for (int j = 1; j < N-1; j++) {
						if(arr[i][j][0]==0) continue;
						answer+=arr[i][j][0];
						queue.add(new micro(i,j,arr[i][j][0],arr[i][j][1]));
						arr[i][j][0] = 0;
						arr[i][j][1] = 0;
						arr[i][j][2] = 0;
								
						
					}
				}

				
			//	System.out.println(answer);
				n++;
			}
			System.out.println("#"+t+" "+answer);
			
			
		}


	}

}
