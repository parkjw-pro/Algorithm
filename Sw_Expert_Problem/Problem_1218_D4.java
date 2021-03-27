package com.ssafy;

import java.util.Scanner;
import java.util.Stack;

public class Problem_1218_D4 {

static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			
			int N = sc.nextInt();
			String str = sc.next();
			int answer = 1;
			
			for (int i = 0; i < N; i++) {
				
				char token = str.charAt(i);
				
				switch( token ) {
					case '<' :
					case '{' :
					case '(' :
					case '[' : stack.push(token); break;
					default	 :
						if (!stack.isEmpty()) {
							
							char prev = stack.pop();
							if (token == '>' && prev != '<') {
								answer = 0;
								break;
							}else if (token == ']' && prev != '[') {
								answer = 0;
								break;
							}else if (token == '}' && prev != '{') {
								answer = 0;
								break;
							}else if (token == ')' && prev != '(') {
								answer = 0;
								break;
							}
						}
				}
//				if(answer!=1) {
//					break;
//				}
			}
			System.out.println("#" + t + " " + answer);
		}
		sc.close();
	}
}