import java.util.*;
class Solution {
    
	public  int[] solution(int[] progresses, int[] speeds) {

		int[] dep = new int[speeds.length];
		for (int i = 0; i < dep.length; i++) {
			dep[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
		}

		int release = dep[0];
		int count = 0;
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < dep.length; i++) {
			if (release >= dep[i]) {
				count++;
			} else {
				list.add(count);

				release = dep[i];
				count = 1;
			}
		}

		list.add(count);

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).intValue();
		}

		return answer;
	}

}