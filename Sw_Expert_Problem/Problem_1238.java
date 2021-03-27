package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1238 {
	
	static boolean map[][];
	static boolean visited[];
	static int pos;
	static int answer;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		int T = 10;
		for (int Test = 1; Test <= T; Test++) {
			
			int N = sc.nextInt();
			int start = sc.nextInt();
			map = new boolean [101][101];
			visited = new boolean[101];
			for (int i = 1; i <= N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = true;
			}
			bfs3(start);
			System.out.println("#"+Test+" "+answer);
		}

		sc.close();
	}
	
	private static void bfs3(int n) {
		Queue<Integer>  queue = new LinkedList<Integer>();
		
		visited[n]=true;
		queue.offer(n);

		while(!queue.isEmpty()) {
			int qSize = queue.size();
        	int max = 0;
            for(int i2=1; i2<=qSize; i2++){
                pos = queue.poll();
                if(pos>max) {
                	max = pos;
                	answer = max;}

				for (int i = 0; i < map[pos].length; i++) {
					if(map[pos][i]==true) {
						if(!visited[i]) {
							queue.offer(i);
							visited[i] = true;
						}
					}
				}
            }
		}
		return;
	}		
}	