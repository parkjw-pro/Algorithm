package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_1043_거짓말 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int trueCount = sc.nextInt();
		int trueperson[] = new int[N];
		
		ArrayList<Integer>[] party = new ArrayList[M];
		
		for (int i = 0; i < party.length; i++) {
			party[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < trueCount; i++) {
			int tp = sc.nextInt()-1;
			queue.add(tp);
			trueperson[tp] = 1;
		}
		
		//각각 파티에 대하여
		for (int i = 0; i < M; i++) {
			int personCnt = sc.nextInt();
			for (int j = 0; j < personCnt; j++) {
				party[i].add(sc.nextInt()-1);
			}
			
		}

		

		
		while(!queue.isEmpty()) {
			
			int nowPerson = queue.poll();
			for (int i = 0; i < M; i++) {
				boolean know = false;

				for (int j = 0; j < party[i].size(); j++) {
					if(party[i].get(j)==nowPerson) {
						know = true;
						break;
					}
				}
				for (int j = 0; j < party[i].size(); j++) {
					if(know&&trueperson[party[i].get(j)]!=1) {
						trueperson[party[i].get(j)] = 1;
						queue.add(party[i].get(j));
					}
				}
				
			}
			
		}
		
		int answer = M;
		for (int i = 0; i < M; i++) {
			boolean know = false;

			for (int j = 0; j < party[i].size(); j++) {
				if(trueperson[party[i].get(j)]==1) {
					know = true;
					break;
				}
				
			}
			if(know) {
				answer--;
			}
			
		}
		System.out.println(answer);
	}
}