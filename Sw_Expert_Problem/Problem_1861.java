package com.ssafy;

import java.util.Scanner;

public class Problem_1861 {
	private static int dy[] = {-1,1,0,0};
	private static int dx[] = {0,0,-1,1};
	private static int room[][];
    private static int N;
    private static int roomno=0;
    private static int movecnt=0;
    
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			movecnt = 1;
			room = new int[N][N];
			roomno = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					room[i][j]= sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i,j,room[i][j],1);
				}
			}
			System.out.println("#"+ test_case+" "+ roomno+ " "+movecnt);
		}
		sc.close();
	}
	
	
	// 이 재귀함수는 움직이는 과정에서 +1 이 되는 칸으로만 움직일 수 있다는 가정때문에 쉬운 함수가 되었다.
	// +1이 없었다면, 예외처리에 추가적으로 이미 지나간 곳을 체크해주면서 해야 한다.
	
	private static void dfs(int i, int j,int start, int count) {
		
		if(count > movecnt) {
			
			movecnt=count;
			roomno=start;
		}else if(count == movecnt) {
			
			if(start < roomno) roomno = start;
		}
		for (int j2 = 0; j2 < 4; j2 ++) {
			
			int rc = i + dx[j2]; 
			int rr = j + dy[j2];
			
			if(rc >=0 && rr>=0 && rc<N && rr<N && room[rc][rr] == room[i][j]+1) {
				dfs(rc,rr,start,count+1);
			}
		}
	}
} 