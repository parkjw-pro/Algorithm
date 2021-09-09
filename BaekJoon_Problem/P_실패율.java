import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class P_실패율 {
	
	static int N = 5;
	static int stages[] = {2, 1, 2, 6, 2, 4, 3, 3};

	public static void main(String[] args) {
		
		//사용자들이 도전한 스테이지
		int chall[] = new int[N+1];
		
		//사용자들이 멈춰있는 스테이지 
		int stop[] = new int[N+1];
		double fail[][] = new double[N][2];
		int[] answer = new int[N];
		
		for (int i = 0; i < stages.length; i++) {
		
			
			if(stages[i]<N+1) {
				stop[stages[i]]++;
			}
			for (int j = 1; j <= stages[i]; j++) {
				if(j>=N+1) continue;
				chall[j]++;
			}
		}
		for (int i = 1; i <= N; i++) {
			fail[i-1][1] = i;
			if(chall[i]==0) {
				fail[i-1][0] = 0;
			}else {
				fail[i-1][0] = (double) stop[i] / (double) chall[i];
			}
			System.out.println(fail[i-1][0]);
		}
		//fail배열에 들어가있는데 fail배열을 인덱스를 유지한채로 정렬해야함.
		
		Arrays.sort(fail, new Comparator<double[]>() {
		    public int compare(double[] o1, double[] o2) {
		        return Double.compare(o2[0], o1[0]);
		    }
		});


		
		for (int i = 0; i < fail.length; i++) {
			answer[i] = (int) fail[i][1];
		}
		

	}

}
