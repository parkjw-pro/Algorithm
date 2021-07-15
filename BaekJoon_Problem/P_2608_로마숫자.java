package com.ssafy;

import java.util.HashMap;
import java.util.Scanner;

public class P_2608_로마숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		s1 = s1.replaceAll("IV", "A");
		s1 = s1.replaceAll("IX", "B");
		s1 = s1.replaceAll("XL", "E");
		s1 = s1.replaceAll("XC", "F");
		s1 = s1.replaceAll("CD", "G");
		s1 = s1.replaceAll("CM", "H");

		s2 = s2.replaceAll("IV", "A");
		s2 = s2.replaceAll("IX", "B");
		s2 = s2.replaceAll("XL", "E");
		s2 = s2.replaceAll("XC", "F");
		s2 = s2.replaceAll("CD", "G");
		s2 = s2.replaceAll("CM", "H");

		HashMap<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);//
		map.put("C", 100);//
		map.put("D", 500);//
		map.put("M", 1000);//
		map.put("A", 4);
		map.put("B", 9);
		map.put("E", 40);//
		map.put("F", 90);//
		map.put("G", 400);//
		map.put("H", 900);//

		int sum1 = 0;

		for (int i = 0; i < s1.length(); i++) {
			sum1 = sum1 + map.get(s1.substring(i, i + 1));
		}
		int sum2 = 0;
		for (int i = 0; i < s2.length(); i++) {
			sum2 = sum2 + map.get(s2.substring(i, i + 1));
		}

		int answer1 = sum1 + sum2;
		System.out.println(answer1);

		StringBuilder sb = new StringBuilder();

		while (answer1 >= 1000) {
			sb.append("M");
			answer1 -= 1000;
		}
		if (answer1 >= 900) {
			sb.append("CM");
			answer1 -= 900;
		}

		if (answer1 >= 500) {
			sb.append("D");
			answer1 -= 500;
		}

		if (answer1 >= 400) {
			sb.append("CD");
			answer1 -= 400;
		}
		while (answer1 >= 100) {
			sb.append("C");
			answer1 -= 100;
		}

		if (answer1 >= 90) {
			sb.append("XC");
			answer1 -= 90;
		}

		if (answer1 >= 50) {
			sb.append("L");
			answer1 -= 50;
		}

		if (answer1 >= 40) {
			sb.append("XL");
			answer1 -= 40;
		}
		while (answer1 >= 10) {
			sb.append("X");
			answer1 -= 10;
		}

		if (answer1 >= 9) {
			sb.append("IX");
			answer1 -= 9;
		}

		if (answer1 >= 5) {
			sb.append("V");
			answer1 -= 5;
		}

		if (answer1 >= 4) {
			sb.append("IV");
			answer1 -= 4;
		}
		while (answer1 >= 1) {
			sb.append("I");
			answer1 -= 1;
		}
		System.out.println(sb);

	}

}
