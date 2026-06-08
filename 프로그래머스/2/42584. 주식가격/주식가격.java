import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	class Node {
		int idx;
		int v;
		int cnt;

		Node(int idx, int v, int cnt) {
			this.idx = idx;
			this.v = v;
			this.cnt = cnt;
		}
	}

	public int[] solution(int[] prices) {
		int[] answer = {};
		int len = prices.length;
		answer = new int[len];

		Deque<Node> dq = new ArrayDeque<>();
		dq.addLast(new Node(0, prices[0], 0));

		for (int i = 1; i < len; i++) {
			int size = dq.size();
			while (size > 0) {
				size--;

				Node cur = dq.removeFirst();
				if (cur.v <= prices[i])
					dq.addLast(new Node(cur.idx, cur.v, cur.cnt + 1));
				else
					answer[cur.idx] = cur.cnt + 1;

			}
			dq.addLast(new Node(i, prices[i], 0));
		}

		while (!dq.isEmpty()) {
			Node cur = dq.removeFirst();
			answer[cur.idx] = cur.cnt;
		}
		return answer;
	}
}

