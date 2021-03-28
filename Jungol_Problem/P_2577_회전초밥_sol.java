package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 회전초밥의 접시를 연속적으로 4개(쿠폰 포함 5개) 추출 후 별도의 자료구조( 배열... ) 에 넣고 그 자료구조가 완성될 때마다 계산하면 시간 초과
// 슬라이딩 윈도우 기법으로 인덱스만 옮겨가면서 앞에 하나를 버리고 뒤에 하나를 추가하는 방법 사용
// 가짓수 계산은 visit 를 매번 전체 순회하면서 계산하지 않고, 하나 버리고, 새로 추가되면 max 를 ++ 또는 -- 감소 시켜서 보정 한 후 max 와 비교
// Scanner 대신 BudderedReader 사용
// OOOOOOOO|OOO  N + k - 1 개 배열 
// OOOOOOOO|OOOO N + k 개 배열 (X)
// N 개를 초과하는 새 접시 --> ( N-1 + K )%N 로도 가능
public class P_2577_회전초밥_sol {
    static int N, d, k, c;
    static int[] table;
    static int[] visit = new int[3001]; // 가짓수 max + 1 ( 1 부터 시작 )
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    
    table = new int[N];
    for (int i = 0; i < N; i++) {
        table[i] = Integer.parseInt(br.readLine());
    }

    visit[c] = 1;
    int kind = 1;
    
    for (int i = 0; i < k; i++) {
        if( visit[ table[i] ] == 0 ) kind++;
        visit[ table[i] ] ++;
    }

    max = Math.max(max, kind);
    for (int i = k; i < N-1+k; i++) {
        
        // 맨 앞 접시 제거
        int dish;
        
        dish = table[i-k];
        
        visit[ dish ] --; // 맨 앞자리 초기화
        if( visit[ dish ] == 0 ) kind--;
        
        // 새 접시 추가 
        if( i < N ) {
            dish = table[i];
        }else {
            dish = table[i-N];
        }
        
        if( visit[ dish ] == 0 ) kind++;
        visit[ dish ] ++; // 맨 앞자리 추가
        
        max = Math.max(max, kind);
    }

    System.out.println(max);
}
}