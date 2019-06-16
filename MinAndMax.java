
public class MinAndMax {

	public static void main(String[] args) {
		String s ="1 2 3 4";
		MinAndMax mx = new MinAndMax();
		System.out.println(mx.solution(s));
	}
	
	public String solution(String s) {
	      String answer = "";
	      
	      String splitArr[] = s.split("\\s");
	      int max=0, min=0;
	      int val;
	      for(int i=0; i<splitArr.length; i++){
	    	  val = Integer.parseInt(splitArr[i]);
	    	  if(i== 0) {
	    		  max = val;
	    		  min = val;
	    	  }
	    	  else {
	    		  if(val > max){
	  	            max = val;
	  	        }
	    		  else if(val < min ){
	  	            min = val;
	  	        } 
	    	  }
	      }
	      
	      answer += min+" "+max;
	      return answer;
	  }

}
