package com.ssafy;

import java.util.Scanner;

//https://118k.tistory.com/307
public class JO_1681_해밀턴순환회로_sol {

	static int min = Integer.MAX_VALUE;

	static int[][] array;
	static int[] visit;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		array = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = in.nextInt();
			}
		}
		in.close();

		int start = 0;
		visit = new int[n];
		visit[start] = 1;

		// 최소값 확인
		move(start, start, 0, 1);

		// 이동 경로도 같이 확인
		// moveWithPath(start, start, 0, 1, String.valueOf(start) + " ");

		System.out.println(min);
	}

//start 변수를 고정해서, 처음으로 되돌아가는 계산 사용
	public static void move(int start, int location, int sum, int count) {

		// 마지막 위치까지 도달
		if (count == visit.length) {
			// 다시 시작 위치로 돌아갈 수 있는지 확인
			if (array[location][start] == 0)
				return;

			// 시작 위치로 돌아가는 값까지 추가해서 최소값 확인
			sum += array[location][start];
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < visit.length; i++) {

			// 가지 않은 노드, 갈 수 있는 노드를 확인하여 이동
			if (visit[i] == 0 && array[location][i] != 0) {
				visit[i] = 1;
				move(start, i, sum + array[location][i], count + 1);
				visit[i] = 0;
			}
		}
	}

//이동 경로까지 추가해서 확인 
	public static void moveWithPath(int start, int location, int sum, int count, String path) {

		if (count == visit.length) {
			if (array[location][start] == 0)
				return;

			sum += array[location][start];

			System.out.printf("%s : %d\n", path + String.valueOf(start), sum);

			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < visit.length; i++) {

			if (visit[i] == 0 && array[location][i] != 0) {
				visit[i] = 1;
				moveWithPath(start, i, sum + array[location][i], count + 1, path + String.valueOf(i) + " ");
				visit[i] = 0;
			}
		}
	}
}