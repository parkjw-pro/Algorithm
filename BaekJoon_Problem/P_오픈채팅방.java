import java.util.HashMap;

public class P_오픈채팅방 {
	
	static String[] record = {"Enter u M","Enter i P","Leave u","Enter u k","Change i R"};

	
	// 아이디 해당하는 배열을 만든다.
	// 아이디와 닉네임을 해쉬로 매칭
	//
	// enter or change면 해쉬의 벨류값을 수정해준다.
	// 벨류값이 수정되면 바로 answer에 적용시킨다.
	//
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		int count = 0;
		
		//최종까지갔을때의 마지막 닉네임을 해쉬값으로 저장.
		for (int i = 0; i < record.length; i++) {
			if(record[i].substring(0,5).equals("Enter")) {
				count++;
				int p1 = record[i].indexOf(" ");
				int p2 = record[i].lastIndexOf(" ");
				map.put(record[i].substring(p1+1,p2), record[i].substring(p2+1,record[i].length()));
				  
			}else if(record[i].substring(0,6).equals("Change")) {
				int p1 = record[i].indexOf(" ");
				int p2 = record[i].lastIndexOf(" ");
				map.put(record[i].substring(p1+1,p2), record[i].substring(p2+1,record[i].length()));
			}else if(record[i].substring(0,5).equals("Leave")) {
				count++;
			}
			
		}
		String[] answer = new String[count];
		count = 0;
		for (int i = 0; i < record.length; i++) {
			int p1 = record[i].indexOf(" ");
			int p2 = record[i].lastIndexOf(" ");
			if(record[i].substring(0,5).equals("Enter")) {
				String id = record[i].substring(p1+1,p2);
				String nickname = map.get(id);
				answer[count] = nickname+"님이 들어왔습니다."; 
				count++;
				
				
			}else if(record[i].substring(0,5).equals("Leave")) {
				String id = record[i].substring(p1+1,record[i].length());
				String nickname = map.get(id);
				answer[count] = nickname+"님이 나갔습니다."; 
				count++;
			}
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
