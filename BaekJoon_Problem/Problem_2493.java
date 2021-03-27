package com.ssafy;


import java.io.*;
import java.util.*;

public class Problem_2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<tower> stack = new Stack<tower>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            long a = Long.parseLong(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek().height >= a){
                    bw.write(stack.peek().position + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) bw.write("0 ");
            stack.push(new tower(a, i));
        }

        bw.flush();
        br.close();
        bw.close();
    }
    static class tower{
        long height;
        int position;
        public tower(long height, int position){
            this.height = height;
            this.position = position;
        }
    }
}