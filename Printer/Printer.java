package Printer;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
	static Printer printer = new Printer();
	
	public static void main(String[] args) {
		int priorities[] = new int [] { 2, 1, 3, 2 };
		int location = 2;

		System.out.println(printer.solution(priorities, location));
	}
	
	public int solution(int[] priorities, int location) {
		int answer = 0;
		
		Queue<KeyValue> orderQueue = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			orderQueue.offer(new KeyValue(i, priorities[i]));
		}
		
		while(!orderQueue.isEmpty()) {
			KeyValue temp = orderQueue.poll();
			boolean maxFlag = true;
			
			for(KeyValue qs : orderQueue) {
				if(qs.getValue() > temp.getValue()) {
					orderQueue.offer(new KeyValue(temp.getIdx(), temp.getValue()));
					maxFlag = false;
					break;
				}
			}
			
			if(maxFlag) {
				answer++;
				if(location == temp.getIdx()) {
					break;
				}
			}
		}
        return answer;
    }

}
