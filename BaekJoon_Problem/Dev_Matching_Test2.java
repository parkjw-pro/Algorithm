package com.ssafy;

public class Dev_Matching_Test2 {
	// 회전문제
	// 회전하는 알고리즘만 구현하면 최소값은 회전을 시키는 함수안에서 min값을 갱신하면서 찾으면 된다.
	// 
	// 회전하는 알고리즘 
	// 회전은 시계방향으로 돈다.
	// temp에 첫값(시작점 y-1열의 값)을 넣어놓고, for문을 돌려 위치는 바꾼다.
	// 방향을 바꾸는 알고리즘은 -1 을 곱해서 할건지 아니면 포문4개로 노가다로 할건지 정하자.
	// 크기가 작으니 그냥 포문4개로

	static int queries[][] = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
	static int rows = 6;
	static int columns = 6;
	static int map[][];
	static int mapcopy[][];

	
	public static void main(String[] args) {
		
		int num = 1;
		map = new int[rows][columns];
		mapcopy = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = num;
				mapcopy[i][j] = num;
				num ++;
			}
		}
		int result[] = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			result[i] = roll(queries[i]);
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}

	}
	//(2,2) (5,4)
	//여기서 쿼리 하나하나마다 회전시킨다.
	private static int roll(int[] query) {

		int min = Integer.MAX_VALUE;
		int si = query[0]-1;
		int sj = query[1]-1;
		int rowl = query[3]-query[1];
		int coll = query[2]-query[0];
		//덮어써지기 전에 temp에 저장하자
		for (int i = 1; i <= rowl; i++) {
			sj = sj +1;
			if(map[si][sj-1]<min) {
				min = map[si][sj-1];
			}
			mapcopy[si][sj] = map[si][sj-1];
		}
		for (int i = 1; i <= coll; i++) {
			si = si +1;
			if(map[si-1][sj]<min) {
				min = map[si-1][sj];
			}
			mapcopy[si][sj] = map[si-1][sj];
		}
		for (int i = 1; i <= rowl; i++) {
			sj = sj -1;
			if(map[si][sj+1]<min) {
				min = map[si][sj+1];
			}
			mapcopy[si][sj] = map[si][sj+1];
		}
		for (int i = 1; i <= coll; i++) {
			si = si -1;
			if(map[si+1][sj]<min) {
				min = map[si+1][sj];
			}
			mapcopy[si][sj] = map[si+1][sj];
		}
		
		//맵 복사
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = mapcopy[i][j];
			}
		}
		return min;
	}

}
