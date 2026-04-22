import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public static int solution(int[] citations) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < citations.length; i++) {
			list.add(citations[i]);
		}

		Collections.sort(list, Collections.reverseOrder());

		int answer = 0;
		int len = citations.length;

		for (int i = 0; i < len; i++) {

			if (list.get(i) >= i + 1) {
				answer = i + 1;

			}
		}

		return answer;
	}
}