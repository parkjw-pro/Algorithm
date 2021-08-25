package com.ssafy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P_20056_마법사상어와파이어볼 {
	

	
	static class fb {
		int r;
		int c;
		int m;
		int s;
		int d;
		
		public fb(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
		
		
	}
	
	static int dy[] = {-1,-1,0,1,1,1,0,-1};
	static int dx[] = {0,1,1,1,0,-1,-1,-1};

	static int N;
	static int M;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		int arr[][][] = new int[N][N][5];
		Queue<fb> queue = new LinkedList<fb>();
		int answer = 0;	

		
		
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			
			queue.add(new fb(r,c,m,s,d));
			
			
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j][2] = -1;
			}
		}
		//큐에 파볼이 들어간 상황, 
		//arr[r][c][0] 질량
		//arr[r][c][1] 속력
		//arr[r][c][2] 합쳐진방향
		//arr[r][c][3] 파볼갯수
		//arr[r][c][4] 혼자방향
		
		//시작하면 파이어볼을 큐에있는 파이어볼을 꺼내 퍼뜨리고, 퍼트려진걸 다시 하나로 뭉쳐서, 다시 큐에 넣는다.
		
		int n = 0;
		while(n<K) {
			answer = 0;
			//큐에있는 파볼을 모두 꺼내 이동시킨다.
//			System.out.println();
			while(!queue.isEmpty()) {
				
				fb f = queue.poll();
				
				//퍼진 위치
				int r = f.r+(dy[f.d]*f.s);
				int c = f.c+(dx[f.d]*f.s);
				
				
				if(r<0) {
					r = N+r%N;
				}
				if(c<0) {
					c = N+c%N;
				}
				if(r>=N) {
					r = r%N;
				}
				if(c>=N) {
					c = c%N;
				}
				
//				System.out.println(r+" "+c+" "+f.d);
				arr[r][c][0]+=f.m;
				arr[r][c][1]+=f.s;
				
				// -1 공백/ 0 짝 /1 홀 /2 다름
				if(arr[r][c][2]==-1) {
					arr[r][c][2] = f.d%2;
					arr[r][c][4] = f.d;
				}else if(arr[r][c][2]==0) {
					if(f.d%2!=0) {
						arr[r][c][2] = 2;
					}
				}else if(arr[r][c][2]==1) {
					if(f.d%2==0) {
						arr[r][c][2] = 2;
					}
				}
				
				arr[r][c][3]++;
				
			}
			//다 퍼뜨림
//		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j][3]==1) {
					
					//

//					System.out.print(i+" "+j+" "+arr[i][j][4]+" ");
//					System.out.println("============");
					queue.add(new fb(i,j,arr[i][j][0],arr[i][j][1],arr[i][j][4]));
					answer+=arr[i][j][0];
					arr[i][j][0] = 0;
					arr[i][j][1] = 0;
					arr[i][j][2] = -1;
					arr[i][j][3] = 0;
					arr[i][j][4] = 0;
					
					
				//2개이상일때	
				}else if(arr[i][j][3]>1) {
					
					int m = arr[i][j][0]/5;
					
					arr[i][j][0] =0;
					//질량이 0이되면 사라진다.
					if(m==0) {
						arr[i][j][0] = 0;
						arr[i][j][1] = 0;
						arr[i][j][2] =-1;
						arr[i][j][3] = 0;
						continue;
					}

					//System.out.println(i+" "+j);
					answer+=4*m;
					int s = arr[i][j][1]/arr[i][j][3];
					arr[i][j][1] = 0;

					
					if(arr[i][j][2]==1||arr[i][j][2]==0) {
						queue.add(new fb(i,j,m,s,0));
						queue.add(new fb(i,j,m,s,2));
						queue.add(new fb(i,j,m,s,4));
						queue.add(new fb(i,j,m,s,6));
					}else {
						queue.add(new fb(i,j,m,s,1));
						queue.add(new fb(i,j,m,s,3));
						queue.add(new fb(i,j,m,s,5));
						queue.add(new fb(i,j,m,s,7));
					}
					arr[i][j][2] = -1;
					arr[i][j][3] = 0;
					
					

				}
			}
		}	
		n++;
			
			
			
			
			
			
			
		}
		System.out.println(answer);
		

	}

}
