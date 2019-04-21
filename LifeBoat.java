/* 4월 셋째주(2) */
public class LifeBoat {
	public static int solution(int[] people, int limit) {
        int answer = 0; // 보트의 이동횟수
//        int defference=0;
        
        int j=0;
        if(people.length >= 1 && people.length <= 50000 && limit >= 40 && limit <= 240) {
        	for(int i=people.length-1; i > j; i--) {
        		if(people[i] + people[j] <= limit) {
        			answer++;
        			j++;
        		}
        	}

        }
        answer = people.length - answer;
        return answer;
    }
	
	public static void sortingASC(int[] arr) {
		int temp;
		
		for(int i=arr.length; i>0; i--) {
			for (int j=0; j<i-1; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		int peopleInfo[] = new int[] {70, 50, 80, 50};
		int limit = 100;

		sortingASC(peopleInfo);
		int result = solution(peopleInfo, limit);
		System.out.println(result);
		
		
		
	}
	
}
