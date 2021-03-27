package com.ssafy;

import java.util.*;
import java.io.*;

// 시뮬레이션 - 초 단위로 반복
// 먼지 확산을 한 개의 map 에서 처리 X <-- 별도의 map 필요
// 먼지 확산 계산 from (원래 map) 계산 결과 반영  to (임시 map)
//        완료 후 계산 결과 원래 amp 재 반영
// 청정기 실행 계산 from (원래 map) 계산 결과 반영  to (임시 map)
//        완료 후 계산 결과 원래 amp 재 반영 단, 이 경우 청정기에 의해 영향 받은 부분만 반영(테두리)
public class P_17144_미세먼지안녕_sol {

public static int[][] cPos = new int[2][2];   //공기청정기 위치 저장
public static int R, C, T, ans;
public static int[][] map, temp_map;
public static int[] dx = { 1, -1, 0, 0};
public static int[] dy = { 0,  0, 1, -1};
 
public static void main(String[] args) throws Exception {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
    
    map = new int[R][C];

    int cIdx = 0;
    for (int i = 0; i < R; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < C; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            if (map[i][j] == -1) {
                cPos[cIdx][0] = i;
                cPos[cIdx][1] = j;
                cIdx++;
            }
        }
    }
    
    temp_map = new int[R][C];
    
    for (int i = 0; i < T; i++) {
        spread();
        clear();
    }
    
    
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (map[i][j] <= 0) continue;
            ans += map[i][j];
        }
    }
    System.out.println(ans);
    
}
 
public static void spread() {
    
    initTempMap();
    
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            temp_map[i][j] += map[i][j];
            if (map[i][j] < 5) continue;
            
            int spreadCnt = map[i][j] / 5;
            
            for (int k = 0; k < 4; k++) {
                int ny = i + dy[k];
                int nx = j + dx[k];
                //해당 맵에 퍼트릴 수 있는지 확인
                if (ny >= 0 && ny < R && nx >= 0 && nx < C && map[ny][nx] != -1) {
                    temp_map[i][j] -= spreadCnt;
                    temp_map[ny][nx] += spreadCnt;
                }
            }
        }
    }
    applySpread();
}
 
   
public static void clear() {
    
    initTempMap();
    
    for (int idx = 0; idx < 2; idx++) {

        int ny = cPos[idx][0];
        int nx = cPos[idx][1] + 1;
        
        // right
        while (nx < C - 1) {
            temp_map[ny][nx + 1] = map[ny][nx];
            nx++;
        }
        //idx 따라 상, 하
        if (idx == 0) {
            while (ny > 0) {
                temp_map[ny - 1][nx] = map[ny][nx];
                ny--;
            }
        } else {
            while (ny < R - 1) {
                temp_map[ny + 1][nx] = map[ny][nx];
                ny++;
            }
        }
        //left
        while (nx > 0) {
            temp_map[ny][nx - 1] = map[ny][nx];
            nx--;
        }
        
        // idx 따라 공기청정기 위치 전까지
        if (idx == 0) {
            while (ny < cPos[idx][0] - 1) {
                temp_map[ny + 1][nx] = map[ny][nx];
                ny++;
            }
        } else {
            while (ny > cPos[idx][0] + 1) {
                temp_map[ny - 1][nx] = map[ny][nx];
                ny--;
            }
        }
    }
    applyClear();
}
 
static void initTempMap() {

    temp_map= new int[R][C];
}


public static void applySpread() {
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            map[i][j] = temp_map[i][j];
        }
    }
}
 
public static void applyClear() {
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (i == 0 || i == R - 1 || j == 0 || j == C - 1 || i == cPos[0][0] || i == cPos[1][0]) {
                map[i][j] = temp_map[i][j];
            }
        }
    }
    map[cPos[0][0]][cPos[0][1]] = -1;
    map[cPos[1][0]][cPos[1][1]] = -1;
}
 
}
