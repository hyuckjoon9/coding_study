import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public static boolean solution(String s) {
		boolean answer = true;

		Deque<Character> dq = new ArrayDeque<>();

		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				dq.addLast('(');
				continue;
			}

			if (dq.isEmpty())
				return false;
			dq.removeLast();

		}

		return dq.isEmpty();
	}
}