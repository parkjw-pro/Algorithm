package com.ssafy;


import java.util.Scanner;
 
public class P_1681_해밀턴순환회로 {
     

    static int N,map[][];

    static int answer = Integer.MAX_VALUE;
    static int place[];
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        N = sc.nextInt();
        map = new int[N][N];
        place = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] =sc.nextInt();
            }
        }
        
        for (int i = 0; i < N; i++) {
            place[i]= i;
             
        }
        
        //첫번째는 정해짐.
        permutation(1);
         
        if(answer==Integer.MAX_VALUE) {
            System.out.println(0);
        }else {
            System.out.println(answer);
        }
    }
     
    private static void permutation(int cnt) {
         
        if(cnt==N) {
            int sum = 0;
            if(map[place[N-1]][place[0]]==0) return;
             
            for (int i = 0; i < N-1; i++) {
                if(map[place[i]][place[i+1]]==0) {return;}
                sum = sum+ map[place[i]][place[i+1]];
            }
            sum = sum+map[place[N-1]][place[0]];
             
 
            answer = Math.min(answer, sum);
            return;
        }
        
        for (int i = cnt; i < N; i++) {
 
            int temp = place[cnt];
            place[cnt] = place[i];
            place[i]= temp;
            
           //가지치기 과정.
			if(cnt<N-1) {
				if(map[place[cnt]][place[cnt+1]]==0) {
		            temp = place[cnt];
		            place[cnt] = place[i];
		            place[i]= temp;
					continue;
				}
			}
			
            permutation(cnt+1);//다음 자리 순열
             
            temp = place[cnt];
            place[cnt] = place[i];
            place[i]= temp;
        }
    }
}