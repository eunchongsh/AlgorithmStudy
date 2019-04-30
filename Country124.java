import java.util.ArrayList;
import java.util.Collections;

public class Country124 {
	
	public String solution(int n) {
		String answer = "";
	      
	    int countryNum[] = new int[] {1, 2, 4};
	    int remainder = 0; // 나머지 
	    int quotient = n; //몫
	     
	    ArrayList<Integer> calArr = new ArrayList<>();
	    
	    while(quotient > 0) {
	    	remainder = quotient % countryNum.length;
	    	quotient /= countryNum.length;
	    	if(quotient > 0 && remainder == 0 ) {
	    		quotient--;
	    	}
	    	calArr.add(remainder);
	    }
	    
	    Collections.reverse(calArr);
	    
	    for(int i : calArr) {
	    	if(i == 0 ) {
	    		i = 3;
	    	}
	    	answer += countryNum[i-1];
	    
	    }
	    return answer;
	}
	
	
	public static void main(String[] args) {
		Country124 country = new Country124();
		System.out.println("결과값 : " + country.solution(22));

	}

}
