package com.ssafy;

import java.util.Scanner;

public class P_11403_경로찾기 {
	
    static int map[][];
    static int N;
    static boolean[]visited;

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
 
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        for (int k = 0; k < N; k++)
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (map[i][k]==1 & map[k][j]==1)
                        map[i][j] = 1;
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
				
			}
			System.out.println();
		}

	}
}

