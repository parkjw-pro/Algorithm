package com.ssafy;

import java.util.Scanner;

public class Problem_1873 {
	static char direction [] = {'^','v','<','>'};
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int H = sc.nextInt();
			int W = sc.nextInt();
			sc.nextLine();
			int index_i=0;// 전차의 현재 행위치
			int index_j=0;// 전차의 현재 열위치
			
			char map[][] = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				int o=0;
				String str = sc.nextLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(o);
					o++;
				
					for (int j2 = 0; j2 < direction.length; j2++) {
						if(map[i][j]==direction[j2]) {
							index_i = i;
							index_j = j;}
					}
				}
			}
			int N = sc.nextInt();
			sc.nextLine();
			char move[] = new char[N];
			String str = sc.nextLine();
			
			for (int i = 0; i < N; i++) {
				
				move[i] = str.charAt(i);
			}
			for (int i = 0; i < N; i++) {
				
				switch (move[i]) {
				case 'U':
					map[index_i][index_j] = '^';
					if((index_i-1)>=0 && map[index_i-1][index_j]=='.') 
					{
						map[index_i-1][index_j]='^';
						map[index_i][index_j]='.';
						index_i--;
					}
					break;
					
				case 'D':
					map[index_i][index_j] = 'v';
					if(index_i+1<W&&map[index_i+1][index_j]=='.')
					{
						map[index_i+1][index_j]='v';
						map[index_i][index_j]='.';
						index_i++;
					}
					break;
					
				case 'L':
					map[index_i][index_j] = '<';
					if(index_j-1>=0&&map[index_i][index_j-1]=='.') 
					{
						map[index_i][index_j-1]='<';
						map[index_i][index_j]='.';
						index_j--;
					}
					break;
					
				case 'R':
					map[index_i][index_j] = '>';
					if((index_j+1)<W&&map[index_i][index_j+1]=='.') 
					{
						map[index_i][index_j+1]='>';
						map[index_i][index_j]='.';
						index_j++;
					}
					break;
					
				case 'S':
					for (int k = 0; k < direction.length; k++) {
						if(map[index_i][index_j]==direction[k]) {
							
							if(k<2) {
								for (int j = index_i+dy[k]; j <H && j>=0; j+=dy[k]) {
									if(map[j][index_j]=='#') {break;}
									
									else if(map[j][index_j]=='*')
									{
										map[j][index_j]='.';
										}
								}
								break;
							}
							
							
							else {
							for (int j = index_j+dx[k]; j < W&& j>=0; j+=dx[k]) {
								
								
								if(map[index_i][j]=='#') {break;}
								
								else if(map[index_i][j]=='*')
								{
									map[index_i][j]='.';
									}
						}
							break;
						}
						}
					}
					break;
				default:
					break;
				}
			}
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
	
		}
				System.out.println("");
	}
		}
}
}