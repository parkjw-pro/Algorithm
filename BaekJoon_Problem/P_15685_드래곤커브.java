package com.ssafy;

import java.util.ArrayList;
import java.util.Scanner;

public class P_15685_드래곤커브 {
	
	static int N;
	static int arr[][];
	static int nowi;
	static int nowj;
	static ArrayList<Integer> list;
	static int dy[] = {0,-1,0,1};
	static int dx[] = {1,0,-1,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		list = new ArrayList<>();
		arr = new int[101][101];
		for (int i = 0; i < N; i++) {
			list = new ArrayList<>();
			int c = sc.nextInt();
			int r = sc.nextInt();
			int d = sc.nextInt();
			int degree = sc.nextInt();
			arr[r][c] = 1;

			nowi = r;
			nowj = c;
			nowi = nowi + dy[d];
			nowj = nowj + dx[d];
			arr[nowi][nowj] = 1;
			list.add(d);
			int k = degree;
			while(k>0) {
				int size = list.size();
				for (int j = size-1; j >=0 ; j--) {
					int dd = list.get(j)+1;
//					System.out.println(nowi+" "+nowj+" "+dd);
					if(dd>=4) {
						dd = dd-4;
					}
					nowi = nowi + dy[dd];
					nowj = nowj + dx[dd];
					if(nowi<0||nowj<0||nowi>100||nowj>100) continue;
					arr[nowi][nowj] = 1;
					list.add(dd);
					
				}
				
				k--;
			}
		}
		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j]==1&&arr[i+1][j]==1&&arr[i][j+1]==1&&arr[i+1][j+1]==1) {
					answer++;
				}
			}
		
		}
		System.out.println(answer);
		

	}


}
