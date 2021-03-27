package com.ssafy;

import java.util.Scanner;

public class Problem_1992 {
	
	static int N,cnt_one;
	static int arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		arr = new int[N][N];
		int len = N;
		
		for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - 48;
			}
		}
		quadtree(0,0,len);

	}
	public static void quadtree(int y, int x, int len) {

        if (check(y, x, len)) {
            System.out.print(cnt_one);
        } else {
            System.out.print("(");
		
     
            for (int i = 0; i < 2; i++) {
            	for (int j = 0; j < 2; j++) {
            		quadtree(y + len/2 * i, x + len/2 * j, len/2);
            	}
            }
            System.out.print(")");
        }
	}
    private static boolean check(int y, int x, int len) {
        int std = arr[y][x];
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (std != arr[i][j]) {
                    return false;
                }
            }
        }
        cnt_one = std;
        return true;
    }
}