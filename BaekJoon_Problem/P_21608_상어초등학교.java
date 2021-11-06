package com.ssafy;

import java.util.ArrayList;
import java.util.Scanner;

public class P_21608_상어초등학교 {
	
	static int N;
	static int arr[][];
	static ArrayList<Integer>[] list;
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int answer = 0;
	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		N  = sc.nextInt();
		arr = new int[N][N];
		list = new ArrayList[N*N+1];
		
		for (int i = 1; i < N*N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N*N; i++) {
			int stu = sc.nextInt();
			for (int j = 0; j < 4; j++) {
				int a = sc.nextInt();
				list[stu].add(a);
			}
			sit(stu);
		}
		run();
		System.out.println(answer);
		
	}
	private static void sit(int s) {
		int likesum = 0;
		int absent = 0;
		int ci =Integer.MAX_VALUE;
		int cj =Integer.MAX_VALUE;
		//모든자리 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//해당 자리에 사람이 있으면 패스
				if(arr[i][j]!=0) continue;
				int blank = 0;
				int like = 0;
				
				
				//4방향에 대하여
				for (int k = 0; k < 4; k++) {
					int ni = i + dy[k];
					int nj = j + dx[k];
					if(ni<0||nj<0||ni>=N||nj>=N) continue;
					
					for (int l = 0; l < list[s].size(); l++) {
						if(list[s].get(l)==arr[ni][nj]) {
							like++;
						}
					}
					//빈칸 수 계산
					if(arr[ni][nj]==0) {
						blank++;
					}
				}
				
				//4자리 탐색한 후
				
				//좋아하는사람이 더 많은자리는
				if(likesum<like) {
					likesum = like;
					absent = blank;
					ci = i;
					cj = j;
				}
				//같을때
				if(likesum==like) {
					if(absent<blank) {
						likesum = like;
						absent = blank;
						ci = i;
						cj = j;
					}
					//빈칸수도 같을때
					if(absent==blank) {
						//행번호가 작은거로
						if(ci>i) {
							likesum = like;
							absent = blank;
							ci = i;
							cj = j;
						}
						//행번호도 같아버리면
						if(ci==i) {
							//열번호가 작은거로
							if(cj>j) {
								likesum = like;
								absent = blank;
								ci = i;
								cj = j;
							}
						}

					}
					
				}
				
			}
		}
		arr[ci][cj] = s;
		
	}
	private static void run() {
		//모든자리 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//해당 자리에 사람이 있으면 패스
				int like = 0;
				int s = arr[i][j];
				
				//4방향에 대하여
				for (int k = 0; k < 4; k++) {
					int ni = i + dy[k];
					int nj = j + dx[k];
					if(ni<0||nj<0||ni>=N||nj>=N) continue;
					
					for (int l = 0; l < list[s].size(); l++) {
						if(list[s].get(l)==arr[ni][nj]) {
							like++;
						}
					}
					//빈칸 수 계산
				}
				switch (like) {
				case 0:
					answer = answer + 0;
					break;
				case 1:
					answer = answer + 1;
					break;
				case 2:
					answer = answer + 10;
					break;
				case 3:
					answer = answer + 100;
					break;
				case 4:
					answer = answer + 1000;
					break;
				default:
					break;
				}
				
				//4자리 탐색한 후
				
				//좋아하는사람이 더 많은자리는
				
			}
		}
	}

}
