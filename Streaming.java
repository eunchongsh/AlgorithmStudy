import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class Streaming {
public static void main(String[] args) {
		
		Streaming stm = new Streaming();
		
		String genres[] = new String[] { "classic", "pop", "classic", "classic", "pop" };
		int plays[] = new int[] { 500, 600, 150, 800, 2500 };
		
		int result[] = stm.solution(genres, plays);
		
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int limit = 2;
        
        HashMap<String, Integer> dicMap = new HashMap<>();
        HashMap<Integer, String> switchMap = new HashMap<>();
        LinkedHashMap<String, Integer> dicDescMap = new LinkedHashMap<>();
        
        for(int i=0; i<genres.length; i++) {
        	if(dicMap.containsKey(genres[i])) { // 해당장르가 이미 존재할 경우
        		dicMap.put(genres[i], dicMap.get(genres[i]) + plays[i]);
        	}else { // 해당 장르가 존재하지 않을 경
        		dicMap.put(genres[i], plays[i]);	
        	}
        }
        
        for(String kind : dicMap.keySet()) {
        	switchMap.put(dicMap.get(kind), kind);
        }
        
        TreeMap<Integer, String> treeMap = new TreeMap<>(switchMap);
        Iterator<Integer> iterator = treeMap.descendingKeySet().iterator();
        
        /* 1번에 해당하는 dicDescMap */
        while(iterator.hasNext()) {
        	int key = iterator.next();
        	dicDescMap.put(treeMap.get(key), key);
        }
        
        /* 2번에 해당하는 orgNumKeyHash */
        HashMap<Integer, String> orgNumKeyHash = new HashMap<>();
        ArrayList<Integer> numDescArr = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++) {
        	orgNumKeyHash.put(i, genres[i]);
        	numDescArr.add(plays[i]); // 넣는김에 갯수같은 얘도 같이
//        	System.out.println(i +":"+genres[i]);
        }
        
        TreeMap<Integer, LinkedList<Integer>> nonOrderHash = new TreeMap<>();
        
        /* 3번에 해당하는 nonOrderHash */
        for(Integer num :  orgNumKeyHash.keySet()) {
        	if(!nonOrderHash.containsKey(plays[num])) {
        		nonOrderHash.put(plays[num], new LinkedList<>());
        	}
        	nonOrderHash.get(plays[num]).add(num);
        }
        
        
        Iterator<Integer> iterator2 = nonOrderHash.descendingKeySet().iterator();
        LinkedHashMap<Integer, LinkedList<Integer>> resultHash = new LinkedHashMap<>();
        
        while(iterator2.hasNext()) {
        	int key = iterator2.next();
        	for(int idx : nonOrderHash.get(key)) {
        		if(!resultHash.containsKey(key)) {
        			resultHash.put(key, new LinkedList<>());
        		}
        		resultHash.get(key).add(idx);
        	}
        }
        
        ArrayList<Integer> resultArr = new ArrayList<>();
        
        for(String songKindKey : dicDescMap.keySet()) {
        	ArrayList<Integer> tempOrgNum = new ArrayList<>();
        	
        	// 1차 : 해당 장르의 고유번호만 뽑기 
        	for(Integer orgNumKey : orgNumKeyHash.keySet()) {
        		if(songKindKey.equals(orgNumKeyHash.get(orgNumKey))) {
        			tempOrgNum.add(orgNumKey);
        		}
        	}
        	
        	// 2차 : 뽑은 고유번호에 해당하는 값들을 뽑자
//        	int per = (tempOrgNum.size() > 1) ? tempOrgNum.size() - (tempOrgNum.size() % limit) : 1; 
        	int per = limit;
        	
//          System.out.println("====================== 결과 ====================");
        	for(Integer playCntKey : resultHash.keySet()) {
        		for(Integer orgNumIdx : resultHash.get(playCntKey)) {
        			for(int i : tempOrgNum) {
        				if(orgNumIdx == i && per > 0) {
        					resultArr.add(orgNumIdx);
//        					System.out.println("장르 : "+songKindKey+"\t["+orgNumIdx+"]\t"+"플레이수: "+playCntKey);
        					per--;
        				}
        			}
        		}
        	}
        	
        }
        answer = new int[resultArr.size()];
		
        for(int i=0; i<resultArr.size(); i++) {
        	answer[i] = resultArr.get(i);
        }
        return answer;
	}
	
	
}
