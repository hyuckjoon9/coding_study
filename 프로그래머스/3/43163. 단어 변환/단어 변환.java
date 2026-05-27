import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	String begin;
	String target;
	String[] words;
	int answer;
	Deque<Node> dq;
	boolean[] visited;

	class Node {
		String word;
		int step;

		Node(String word, int step) {
			this.word = word;
			this.step = step;
		}
	}

	public int solution(String begin, String target, String[] words) {
		this.begin = begin;
		this.target = target;
		this.words = words;
		dq = new ArrayDeque<>();
		visited = new boolean[words.length];

		for (int i = 0; i < words.length; i++) {
			int diffCnt = getDiff(begin, words[i]);
			if (diffCnt == 1) {
				dq.addLast(new Node(words[i], 1));
				visited[i] = true;
			}
		}

		if (dq.isEmpty())
			return 0;
		answer = 0;
		check();
		return answer;
	}

	public void check() {
		while (!dq.isEmpty()) {
			Node cur = dq.removeFirst();

			if (cur.word.equals(target)) {
				answer = cur.step;
			}

			for (int i = 0; i < words.length; i++) {
				if (visited[i])
					continue;
				int diffCnt = getDiff(words[i], cur.word);
				if (diffCnt == 1) {
					visited[i] = true;
					dq.addLast(new Node(words[i], cur.step + 1));
				}
			}

		}
	}

	public int getDiff(String a, String b) {
		int diffCnt = 0;

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				diffCnt++;
		}

		return diffCnt;
	}
}