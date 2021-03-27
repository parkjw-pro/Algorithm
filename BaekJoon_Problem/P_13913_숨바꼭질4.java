package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P_13913_숨바꼭질4 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int vis[] = new int[100001];
		int parents[] = new int[100001];

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(N);
        vis[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) break;
            
            for (int i=0; i<3; i++) {
                int next;

                if (i == 0)         next = now + 1;
                else if (i == 1)    next = now - 1;
                else                next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (vis[next] == 0) {
                    q.add(next);
                    vis[next] = vis[now] + 1;
                    parents[next] = now;
                }
            }
        }

		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int index = K;
		while(index!=N) {
			stack.push(parents[index]);
			index = parents[index];
		}
		StringBuilder sb = new StringBuilder();
		 sb.append(vis[K]-1 + "\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		System.out.println(sb.toString());

	}

}
