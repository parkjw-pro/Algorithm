package com.ssafy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 줄기세포배양_sol {
	static class Cell implements Comparable<Cell>{
		int r,c;
		int activity_life;//활성수명(원래수명)
		int inactivity_life;//비활성상태수명(대기시간)
		boolean status;
		Cell(int r, int c, int activity_life){
			this.r = r;
			this.c = c;
			this.inactivity_life = this.activity_life = activity_life;
			status = false;
		}
		@Override
		public int compareTo(Cell o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.activity_life, this.activity_life);
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static PriorityQueue<Cell> lives;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int K = sc.nextInt();
			//최대 K/2시간 대기 후 사방으로 K/2시간 동안 번식한다. 그리고 시작좌표는 1,1
			visited = new boolean[R + K + 2][C + K + 2];
			lives = new PriorityQueue<>();
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					int val = sc.nextInt();
					//세포가 있다면
					if(val > 0) {
						//좌표를 가운데로 밀기 위해서 K의 반만큼 이동
						Cell cell = new Cell(r + K/2, c + K/2, val);
						visited[cell.r][cell.c] = true;
						lives.add(cell);
					}
				}
			}
			
			//K시간동안 세포를 넣고 빼고 넣고 빼고 ..
			for(int k = 0; k < K; k++) {
				//이전 큐는 lives이고 새로 만들어질 신 큐를 만들자.
				PriorityQueue<Cell> nextQ = new PriorityQueue<>();
				//구 큐를 다 처리할때까지 돌자
				while(!lives.isEmpty()) {
					Cell cell = lives.poll();
					//비활성상태의 세포가 나왔다면
					if(!cell.status) {
						//비활성 수명을 1 줄이고
						cell.inactivity_life--;
						//비활성수명이 0으로 대기시간이 끝났다면 활성전환
						if(cell.inactivity_life == 0) {
							cell.status = true;
						}
						nextQ.add(cell);
					}
					else {
						//4방에 번식(원래는 한번만 번식하는거지만. 어차피 한번 하고 나면
						//사방에 뭔가 다 생겨있어서 번식 못함.
						//번식했는지 안했는지 상태관리해도 되지만.. 그냥 못할 번식하는걸로.
						for(int d = 0; d < 4; d++) {
							int nr = cell.r + dr[d];
							int nc = cell.c + dc[d];
							//이미 세포가 존재한다면.. 이전시간에 생긴 세포가 있거나.
							//이번 시간에 생긴 세포였다면 나보다 쎈놈이니까 먼저와있겠지.
							if(visited[nr][nc])
								continue;
							visited[nr][nc] = true;
							nextQ.add(new Cell(nr, nc, cell.activity_life));
						}
						//활성시간 1 감소
						cell.activity_life--;
						//여전히 살아있다면 큐에 넣지만, 죽었다면 큐에 넣지않고 버리자.
						if( cell.activity_life > 0)
							nextQ.add(cell);
					}
				}
				//구 큐를 신 큐로 변경
				lives = nextQ;
			}
			//큐에 남아있는 세포의 수가 살아있는 세포의 수지
			System.out.println("#" + tc + " " + lives.size()); 
		}
	}
}












