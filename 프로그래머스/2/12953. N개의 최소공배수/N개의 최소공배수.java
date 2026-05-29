import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int solution(int[] arr) {
		int answer = 0;

		Deque<Integer> dq = new ArrayDeque<Integer>();

		for (int i = 0; i < arr.length; i += 2) {
			if (i == arr.length - 1) {
				dq.addLast(arr[i]);
				continue;
			}

			dq.addLast(lcm(arr[i], arr[i + 1]));
		}

		while (dq.size() != 1) {
			int len = dq.size();
			for (int i = 0; i < len; i += 2) {
				if (i == len - 1) {
					dq.addLast(dq.removeFirst());
					continue;
				}

				int n1 = dq.removeFirst();
				int n2 = dq.removeFirst();

				dq.addLast(lcm(n1, n2));
			}
		}

		return dq.removeFirst();
	}

	public int lcm(int a, int b) {
		int lcmValue = a / gcd(a, b) * b;

		return lcmValue;

	}

	public int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}

		return a;
	}
}