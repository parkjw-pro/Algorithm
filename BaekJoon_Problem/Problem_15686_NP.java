package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 치킨가계를 조합으로 선택 후, 각 조합이 완성되면 치킨 거리를 계산 최저값을 찾는다.
// 치킨 거리를 계산할 때는 집을 기준으로 치킨 거리를 계산하여 가장 적은 값을 찾는다.
// 반대로 치킨가계를 기준으로 계산하면 늘 가장 가까운 치킨가계를 선택하게 되어 오류
// nextPermutation way
public class Problem_15686_NP {

    static int N, M;
    static int min = Integer.MAX_VALUE;
    public static List<int[]> house, chicken;

static int[] srcArray;
static int[] idxArray;

public static void main(String[] args) throws Exception{

    Scanner sc = new Scanner(System.in);
    house = new ArrayList<int[]>();
    chicken = new ArrayList<int[]>();
    
    N = sc.nextInt();    //도시크기,         2 <= N <= 50
    M = sc.nextInt();    //치킨집 선택 최대값,    1 <= M <= 13

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            int a = sc.nextInt();    //0:빈집,1:집,2:치킨집
            if( a == 1) house.add(new int[]{i,j});
            else if( a == 2) chicken.add(new int[]{i,j});
        }
    }
    
    srcArray = new int[chicken.size()];
    for (int i = 0; i < srcArray.length; i++) {
        srcArray[i] = i;
    }
    idxArray = new int[chicken.size()];
    for (int i = 0; i < M; i++) {
        idxArray[idxArray.length - 1 - i] = 1;
    }
    
    //System.out.println(Arrays.toString(idxArray));
    
    while(true) {
        
        int sum = 0;
        for(int i=0; i<house.size(); i++){
            
            int dist = Integer.MAX_VALUE;
            
            for (int j = 0; j < idxArray.length; j++) {
                
                if( idxArray[j] == 1 ) {
                    dist = Math.min( 
                        dist, 
                        Math.abs(house.get(i)[0] - chicken.get(j)[0]) +
                        Math.abs(house.get(i)[1] - chicken.get(j)[1])
                    );
                }
            }
            
            sum += dist;
        }
        
        min = Math.min(min, sum);
        
        if( !nextPermutation(idxArray) ) break;
        
    }
    
    System.out.println(min);
    sc.close();
}


private static boolean nextPermutation(int array[]) {

    int i = array.length - 1;
    while( i>0 && array[i-1]>=array[i] ) --i;
    
    if( i == 0 ) return false;
    
    int j = array.length - 1;
    while(array[i-1]>=array[j])    --j;
    swap(array,i-1,j);
    
    // reverse
    int k = array.length - 1;
    while(i<k) {
        swap(array,i++,k--);            
    }
    return true;
}


private static void swap(int numbers[],int i,int j) {
    int temp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = temp;
}
}

/*
https://www.acmicpc.net/problem/15686
*/

/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2

5

5 2
0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
2 0 0 1 1
2 2 0 1 2

10

...
*/