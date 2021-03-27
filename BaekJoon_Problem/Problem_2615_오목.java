package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 육목이 안되고, 오목 시 맨 왼쪽 그리고 위쪽 돌을 출력하고.
 * bfs에서 한방향정하고 거기로만 쭉가는 로직을 배움. -> 방향값을 절대값을 해줌으로서 이어지는 방향의 대한 체크가 가능.
 *  
 *  
 * @author Park Jong Won
 *
 */
public class Problem_2615_오목 {
	
	static int map[][] = new int[19][19];
	static int dy[] = {-1,-1,0,1,1,1,0,-1};
	static int dx[] =  {0,1,1,1,0,-1,-1,-1};
	static boolean vis[][] = new boolean[19][19];//방문처리
	static boolean dvis[][][][] = new boolean[19][19][3][3];//방향의 방문처리를 위한 배열-> 크기가 크지 않아 사용
	static boolean flag, flag2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				map[i][j] = sc.nextInt();
				
			}
		}
		//19*19행렬은 하나하나 접근해도 수행시간이 충분해서 돌 하나하나에 접근
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				if(map[i][j]!=0&&!vis[i][j]) {
					bfs(i,j);
					if(flag) {
						System.out.println(map[i][j]);
						System.out.println((i+1)+" "+(j+1));
						flag2 = true;
					}
					flag = false;
				}
			}
		}
		//찾은게 없으면 0출력
		if(!flag2) System.out.println(0);
		sc.close();
	}
	
	//돌 하나하나에 접근해서 bfs싱행.
	public static void bfs(int i,  int j) {
		vis[i][j] = true;
		int count = 1;
		for (int k = 0; k < dx.length; k++) {//해당 바둑알의 8바향에 대하여 탐색시작.
			int ny = i + dx[k];
			int nx = j + dy[k];
			
			//경계조건 만족하고, 해당 바둑알에서 이미 같은 방향으로 탐색한적이 있는지 dvis행렬을 통해 확인 .
			// 오른쪽 위 대각선방향과 왼쪽 아래 대각선 방향은 같은 방향이므로 이 부분을 절대값을 이용하여 같은걸로 처리했음.
			if(ny>=0&&nx>=0&&ny<19&&nx<19&&!dvis[ny][nx][Math.abs(dx[k])][Math.abs(dy[k])]&&map[ny][nx]==map[i][j]) {
				dvis[ny][nx][Math.abs(dx[k])][Math.abs(dy[k])] = true;
				Queue<Integer> queue1 = new LinkedList<Integer>();
				Queue<Integer> count_queue1 = new LinkedList<Integer>();
				
				//객체로 만들어서 넣어주기보다는 그냥 r,c좌표를 각각 큐에 넣어서 진행.
				queue1.offer(ny);
				queue1.offer(nx);
				count_queue1.offer(count+1);
				int count1 = 0;
			
				while(!queue1.isEmpty()) {
					
					int ci = queue1.poll();
					int cj = queue1.poll();
					count1 = count_queue1.poll();
					
					//한 방향으로만 쭉 가는것이니, 위에 포문에서 사용했던 dx, dy배열 그대로 가져와서 쓴다.
					ny = ci + dx[k];
					nx = cj + dy[k];
					
					//다음 돌이 해당 조건에 만족하면 큐에 넣어준다.
					if(ny>=0&&nx>=0&&ny<19&&nx<19&&map[ny][nx]==map[i][j]) {
						dvis[ny][nx][Math.abs(dx[k])][Math.abs(dy[k])] = true;
						queue1.offer(ny);
						queue1.offer(nx);
						count_queue1.offer(count1+1);
					}
				}
				if(count1==5) {
					flag = true;// 오목을 찾으면 flag값을 true로 설정해주고, line42에서 바로 출력을하고 종료
				
				}
			}
		}
	}
}