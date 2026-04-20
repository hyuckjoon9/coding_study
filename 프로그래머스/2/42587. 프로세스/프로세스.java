import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 1;

		List<Integer> list = new ArrayList<>();
		Deque<int[]> dq = new ArrayDeque<>();

		for (int i = 0; i < priorities.length; i++) {
			list.add(priorities[i]);
			dq.addLast(new int[] { priorities[i], i });
		}

		Collections.sort(list, Collections.reverseOrder());

		int listIdx = 0;
		while (!dq.isEmpty()) {
			int num = list.get(listIdx++);

			while (dq.peekFirst()[0] != num) {
				dq.addLast(dq.removeFirst());

			}
			if (dq.removeFirst()[1] == location) {
				return answer;
			}
			answer++;
		}

		return answer;
	}
}