import java.util.HashMap;
import java.util.HashSet;

public class P완주하지못한선수 {
	
	static String participant[] = {"mislav", "stanko", "mislav", "ana"};
	static String completion[] = {"stanko", "ana", "mislav"};

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < participant.length; i++) {
			if(map.containsKey(participant[i])) {
				int a = map.get(participant[i]);
				a = a+1;
				map.remove(participant[i]);
				map.put(participant[i], a);
				set.add(participant[i]+a);
			}else {
				set.add(participant[i]+1);
				map.put(participant[i], 1);
			}
		
		}
		
		for (int i = 0; i < completion.length; i++) {
			int a = map.get(completion[i]);
			map.remove(completion[i]);
			map.put(completion[i], a-1);
			set.remove(completion[i]+a);
			
		}
        String answer = set.toString();
        answer = answer.substring(1, answer.length()-1);
        answer =  answer.replaceAll("[^a-z]", "");
        System.out.println(answer);
	}

}
