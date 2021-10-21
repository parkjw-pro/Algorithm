package com.ssafy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P_16235_나무제테크 {
	
	static int N;
	static int M;
	static int K;
	static int arr[][];
	static int dy[] = {-1,-1,-1,0,0,1,1,1};
	static int dx[] = {-1,0,1,-1,1,-1,0,1};
	static ArrayList<Integer>[] list;
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K=  sc.nextInt();
		map = new int[N][N];
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		list = new ArrayList[N*N];
		for (int i = 0; i < N*N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt()-1;
			int c= sc.nextInt()-1;
			int age = sc.nextInt();
			list[N*r+c].add(age);
		}
		
		//나무 나이순으로 정렬
		for (int i = 0; i < N*N; i++) {
			Collections.sort(list[i]);
		}
		
		
		//k년이 지난후 남은 나무의 수 출력
		for (int i = 0; i < K; i++) {
			run();
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//나무갯수
				int size = list[N*i+j].size();
				answer = answer + size;
			}
		}
		System.out.println(answer);


	}
	private static void run() {
		

		//봄 & 여름
		
		//모든 칸에 대하여
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//나무갯수
				int size = list[N*i+j].size();
				for (int j2 = 0; j2 < size; j2++) {
					
					//순서대로, 나무가 양분을 먹고 나이를 먹는다.
					if(map[i][j]>=list[N*i+j].get(j2)) {
						map[i][j] = map[i][j] - list[N*i+j].get(j2);
						list[N*i+j].set(j2, list[N*i+j].get(j2)+1);
					}else {
						//나이 많은 나무들 다 제거
						for (int k = j2; k < size; k++) {
							//제거함과 동시에 해당 칸에 양분으로 추가.
							//여름
							map[i][j] = map[i][j] + list[N*i+j].get(j2)/2;
							list[N*i+j].remove(j2);
						}
						break;
					}
				}
			}
		}
		//가을
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//나무갯수
				int size = list[N*i+j].size();
				for (int j2 = 0; j2 < size; j2++) {
					//5배수이면
					if(list[N*i+j].get(j2)%5==0) {
						for (int k = 0; k < 8; k++) {
							int ni = i + dy[k];
							int nj = j + dx[k];
							if(ni<0||nj<0||ni>=N||nj>=N) continue;
							list[N*ni+nj].add(1);
						}
					}

				}
			}
		}
		//겨울
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//영양분 공급
				map[i][j] = map[i][j] + arr[i][j];
			}
		}
		//나이정렬
		for (int i = 0; i < N*N; i++) {
			Collections.sort(list[i]);
		}
		
	} 

}
