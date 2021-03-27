package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_7793_나의여신 {
	static Queue<Integer> queue;
	static Queue<Integer> dqueue;
	static int N,M,di,dj;
	static char map[][];
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static int answer;
	static boolean vis[][];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int testcase = 1; testcase <= T; testcase++) {
			queue = new LinkedList<Integer>();//수연이 큐
			dqueue = new LinkedList<Integer>();//악마큐
			answer = -1;
			
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];	
			vis = new boolean[N][M];//방문처리를 위해
			
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]=='S') {
						queue.offer(i);
						queue.offer(j);
						vis[i][j] = true;
					}else if(map[i][j]=='*') {//악마 받으면 dqueue에 저장
						dqueue.offer(i);
						dqueue.offer(j);
					}else if(map[i][j]=='D') {//여신의 위치 저장
						di = i;
						dj = j;
					}
				}
			}
			bfs();
			if(answer == -1) {
				System.out.println("#"+testcase+" "+"GAME OVER");
			}else {System.out.println("#"+testcase+" "+answer);
			}
		}
		sc.close();
	}
	private static void bfs() {
		Queue<Integer> count_q = new LinkedList<Integer>();//이동한 거리를 나타낼 큐 생성
		count_q.offer(0);
		while(!queue.isEmpty()){// bfs안에 병렬적인 bfs있는 느낌
			
			int size = dqueue.size()/2;
			while(size>0) {
				int dei = dqueue.poll();
				int dej = dqueue.poll();
				

				for (int i = 0; i < dx.length; i++) {
					
					int dny = dei + dy[i];
					int dnx = dej + dx[i];
					
					if(dny>=0&&dnx>=0&&dny<N&&dnx<M&&(map[dny][dnx]=='.'||map[dny][dnx]=='S')) {
						map[dny][dnx] = '*';
						dqueue.offer(dny);
						dqueue.offer(dnx);
					}
				}
				size = size -1;
			}
			int size2 = queue.size()/2;
			while(size2>0) {
				
				int si = queue.poll();
				int sj = queue.poll();
				int count = count_q.poll();
				if(si==di&&sj==dj) {
					answer = count;
				}
				
				for (int i = 0; i < dx.length; i++) {
					
					int ny = si +dy[i];
					int nx = sj +dx[i];
		
					if(ny>=0&&nx>=0&&ny<N&&nx<M&&(map[ny][nx]=='.'||map[ny][nx]=='D')&&!vis[ny][nx]) {
						vis[ny][nx] = true;
						queue.offer(ny);
						queue.offer(nx);
						count_q.offer(count+1);
					}
				}
				size2 = size2 -1;
			}
		}
	}
}