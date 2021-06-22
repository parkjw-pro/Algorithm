package com.ssafy;

import java.util.Scanner;

public class Problem_9229 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int Snack[] = new int[N];
			int answer = -1;
			int max = 0;
			int cnt = 0; 
			
			for (int j = 0; j < N; j++) {
				
				int a = sc.nextInt();
				if(a<M) {Snack[cnt] = a;
				cnt++;}
			}
			
			for (int j = 0; j < cnt-1; j++) {
				for (int j2 = j+1; j2 < cnt; j2++) {
					
					if(Snack[j]+Snack[j2]==M) { answer = M; break;}
					else if(Snack[j]+Snack[j2]<M) {
						if(Snack[j]+Snack[j2]>max) {
							max = Snack[j]+Snack[j2];
							answer = max;
						}
					}
				}
				if(answer == M) {break;}
			}
			System.out.println("#"+i+" "+answer);
		}
		sc.close();
	}
}