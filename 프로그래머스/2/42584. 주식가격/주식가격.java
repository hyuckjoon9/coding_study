import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public static int[] solution(int[] prices) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.addLast(0);

		int n = prices.length;

		int[] result = new int[n];

		for (int i = 1; i < prices.length; i++) {

			while (!dq.isEmpty() && prices[dq.peekLast()] > prices[i]) {
				result[dq.removeLast()] = i;
			}
			dq.addLast(i);
		}

		while (!dq.isEmpty()) {
			result[dq.removeLast()] = -1;
		}

		int[] answer = new int[n];

		for (int i = 0; i < n; i++) {

			answer[i] = result[i] == -1 ? n - i - 1 : result[i] - i;

		}
		return answer;
	}
}