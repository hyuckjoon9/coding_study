import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	class Node {
		String word;
		int dist;

		Node(String word, int dist) {
			this.word = word;
			this.dist = dist;
		}
	}

	public int solution(String begin, String target, String[] words) {
		boolean[] visited = new boolean[words.length];

		Deque<Node> dq = new ArrayDeque<>();
		dq.addLast(new Node(begin, 0));

		while (!dq.isEmpty()) {
			Node cur = dq.removeFirst();
			System.out.println("word: " + cur.word + " dist: " + cur.dist);

			for (int i = 0; i < words.length; i++) {
				if (visited[i])
					continue;
				if (!isDiffOne(cur.word, words[i]))
					continue;

				if (words[i].equals(target)) {
					return cur.dist + 1;
				}
				visited[i] = true;
				dq.addLast(new Node(words[i], cur.dist + 1));
			}
		}

		return 0;
	}

	public boolean isDiffOne(String a, String b) {
		int len = a.length();
		int diff = 0;

		for (int i = 0; i < len; i++) {
			if (a.charAt(i) != b.charAt(i))
				diff++;
		}

		return diff == 1;
	}
}