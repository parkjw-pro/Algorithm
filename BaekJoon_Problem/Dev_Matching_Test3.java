package com.ssafy;

import java.util.LinkedList;
import java.util.Queue;

public class Dev_Matching_Test3 {
	
	static String enroll[] = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
	static String referral[] = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
	static String seller[] = {"young", "john", "tod", "emily", "mary"};
	static int amount[] = {12, 4, 2, 5, 10};
	static int result[] = new int[enroll.length];
	
	
		
	public static void main(String[] args) {
		

		for (int i = 0; i < amount.length; i++) {
			for (int j = 0; j < enroll.length; j++) {
				if(enroll[j].equals(seller[i])) {
					bfs(j,amount[i]*100);
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
	private static void bfs(int n, int cost) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		queue.add(cost);
		
		while(!queue.isEmpty()) {
			int cn = queue.poll();
			int ccost = queue.poll();
			
			//추천인이 있다면
			if(!referral[cn].equals("-")){
				result[cn] = result[cn]+ (ccost-(ccost/10));
				
				for (int j = 0; j < enroll.length; j++) {
					if(enroll[j].equals(referral[cn])) {
						queue.add(j);
						queue.add(ccost/10);
						break;
					}
				}
			}else {
				result[cn] = result[cn]+ (ccost-(ccost/10));
			}
		}
	}

}
