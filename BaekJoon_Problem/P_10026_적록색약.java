package com.ssafy;

import java.util.Scanner;

public class P_10026_적록색약 {
	
	static int N;
	static char arr[][];
	static boolean vis[][];
    static int dx[]= {-1,0,1,0};
    static int dy[]= {0,1,0,-1};
    static int answer1 = 0;
    static int answer2 = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new char[N][N];
		vis = new boolean[N][N];
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			arr[i] = s.toCharArray();
		}

		
		//일반인이 느끼는 색구분
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
                if(vis[i][j]==false) {
                	answer1++;
                    char color = arr[i][j];
                    dfs(i,j,color);
                }
				
			}
		}
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(arr[i][j]=='G') {
                    arr[i][j]='R';
                }
            }
        }
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				vis[i][j] = false;
			}
		}
		
		//적록색약이 느끼는 색구분
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
                if(vis[i][j]==false) {
                	answer2++;
                    char color=arr[i][j];
                    dfs(i,j,color);
                }
			}
		}
		
		System.out.println(answer1+" "+answer2);
		

	}
	private static void dfs(int r, int c, int color) {
		vis[r][c]=true;
        for(int i=0;i<4;i++) {
            int rx= r+dx[i];
            int ry=c+dy[i];
            if(rx<0||ry<0||ry>=N||rx>=N) {
                continue;
            }if(vis[rx][ry]==true) {
                continue;
            }if(arr[rx][ry]!=color) {
                continue;
            }if(arr[rx][ry]==color&&vis[rx][ry]==false) {
            	vis[rx][ry]=true;
            	dfs(rx,ry,color);
            }
        }
        return;
		
	}

}
