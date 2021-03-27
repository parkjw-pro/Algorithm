package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class P_18870_좌표압축 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			list.add(a);
		}
		List<Integer> list2 = new ArrayList<Integer>(new LinkedHashSet<Integer>(list));
		Collections.sort(list2);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int a = binarySearch(list2, list.get(i));
			sb.append(a);
			sb.append(" ");

		}
		System.out.println(sb);
	}
	public static int binarySearch(List<Integer> array, int searchValue) {

		int min = 0;
		int max = array.size() - 1;

		while (min <= max) {
			int mid = (min + max) / 2;
			if (array.get(mid) < searchValue) { 
				min = mid + 1;
			} else if (array.get(mid) > searchValue) {
				max = mid - 1;
			} else { 
				return mid;
			}
		}
		return 0;
	}
}
