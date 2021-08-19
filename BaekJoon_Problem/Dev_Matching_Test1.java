package com.ssafy;

public class Dev_Matching_Test1 {
	
	// 0이 아닌 숫자들로만 등수를 계산(최저등수값이 바로 됨)
	// 0이 모두 실제 로또번호와 맞다고 계산(최고 등수값이 됨)
	// 0이 몇개가 들어오나 체크한 후,  들어온 값의 0제외 등수만 체크하면O(n)
	// 최고점수와 최저점수가 O(1)으로  가능.
	

	static int[] answer ;
	

	public static void main(String[] args) {
		answer = new int[2];
		
		int lottos[] = {1, 2, 3, 4, 5, 6};
		int win_nums[] = {7, 8, 9, 10, 11, 12};
		Solution(lottos,win_nums);
		System.out.print(answer[0]+" "+answer[1]);

	}
	public static void Solution(int[] lottos, int[] win_nums) {
		//우선 주어진값이 몇개가 맞았나 계산
		int cong = 0;
		int zero = 0;
		for (int i = 0; i < lottos.length; i++) {
			if(lottos[i]==0) {
				zero++;
			}
			for (int j = 0; j < lottos.length; j++) {
				if(lottos[i]==win_nums[j]) {
					cong ++;
					break;
				}
			}
		}
		//
		answer[0] = 7-(cong+zero);
        if(cong==0){
        	if(zero==0) {
        		answer[0] = 6;
        	}
            answer[1] = 6;
        }else{
        	answer[0] = 7-(cong+zero);
            answer[1] = 7-cong;
           
        }
	}

}
