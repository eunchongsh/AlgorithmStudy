class Solution {
    public int[] solution(int n, String[] words) {
        String[] answer = new String[100];
        int result[] = new int[2];
        
        int answerCnt = 0; // answer배열의 증가하는 cnt값
        String tempWord = null;
        
        int playerNum = 1; 
        int playCnt = 0;
        
        int subEndIdx=0;
        int flag = 0;
        
        for(int i=0; i<words.length; i++) {	
        	
        	if(1 > words.length  &&  words.length > 50) { break;} // 글자는 2 이상 50이하여야 인정 아님 땡
        	
        	if(answerCnt > 0) { // 이전에 누적된 데이터가 있는
        	
        		/* 1. 앞글자 끝말잇기 */
    			subEndIdx = tempWord.length();
    			if(!tempWord.substring(subEndIdx-1, subEndIdx).equals(words[i].substring(0, 1) )) {
    				flag = -1;
    			}
    			else {
    				for(int j=answerCnt-1; j>=0; j--) {

            			/* 2. 중복 체크  */
            			if( answer[j].equals(words[i]) ) {
            				flag = -1;
            			}
            		}
    			}
        	}
        	if(flag == -1) { 
        		playCnt++;
        		break;
        	}
        	
        	answer[answerCnt] = words[i];
        	answerCnt++;
        	playerNum++; //다음플레이어에게 넘겨줌
        	
        	if( (playerNum-1) % n == 0) { //한바퀴 돌았음
        		playerNum = 1;
        		playCnt++;
        	}
        	tempWord = words[i];  // 보기좋은애로 저장 
        }
        
        /* 문제 없이 클리어 */
        if(answerCnt == words.length) { 
        	playerNum = 0;
        	playCnt = 0;
        }
        
        result[0] = playerNum; result[1] = playCnt;
        
        return result;
        
	}

}