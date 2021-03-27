package com.ssafy;
import java.util.Scanner;
import java.util.Stack;

public class Problem_1223 {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> stack1 = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			String str = sc.next();
			for (int i = 0; i < N; i++) {
				
				char token = str.charAt(i);
				
				if(token=='*') {stack.push(token);}
				else if(token=='+')
				{
					if(!stack.isEmpty()) {
						while(stack.peek()=='*') {
							sb.append(stack.pop()) ;
							if(stack.isEmpty()) {break;}
						}
						if(stack.isEmpty()) {stack.push(token);}
						else {
							sb.append(stack.pop());
							stack.push(token);
						}
						
					}else { stack.push(token);}
				}
				else {sb.append(token);}
			}
			while(!stack.empty()) {
				sb.append(stack.pop());
			}

			
			int cal=0 ;
			for (int i = 0; i < N; i++) {
				char tok = sb.charAt(i);
				
				if (tok == '*')
				{
					int k = stack1.pop();
					int k2 = stack1.pop();
					cal = k2 * k;
					stack1.push(cal);
				}
				else if(tok=='+')
				{
					int k = stack1.pop();
					int k2 = stack1.pop();
					cal = k2+k;
					stack1.push(cal);
				}
				else {stack1.push(tok-'0');}
			}
			System.out.println("#"+t+" "+cal);
			}
		}
	}