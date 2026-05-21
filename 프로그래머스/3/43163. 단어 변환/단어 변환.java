import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	String begin;
	String target;
	String[] words;
	int answer = 0;
	int[][] g;
	boolean[] visited;
	int n;

	public int solution(String begin, String target, String[] words) {
		this.begin = begin;
		this.target = target;
		this.words = words;
		n = words.length;
		visited = new boolean[n + 1];

		boolean hasSame = false;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) {
				hasSame = true;
				break;
			}
		}

		if (!hasSame) {
			return 0;
		}

		g = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == j)
					continue;

				if (i == 0) {
					int cnt = 0;
					for (int k = 0; k < begin.length(); k++) {
						if (begin.charAt(k) != words[j - 1].charAt(k)) {
							cnt++;
						}
					}

					if (cnt == 1) {
						g[i][j] = 1;
						g[j][i] = 1;
					}
				} else if (j == 0) {
					int cnt = 0;
					for (int k = 0; k < begin.length(); k++) {
						if (begin.charAt(k) != words[i - 1].charAt(k)) {
							cnt++;
						}
					}

					if (cnt == 1) {
						g[i][j] = 1;
						g[j][i] = 1;
					}
				} else {
					int cnt = 0;
					for (int k = 0; k < words[j - 1].length(); k++) {
						if (words[i - 1].charAt(k) != words[j - 1].charAt(k)) {
							cnt++;
						}
					}

					if (cnt == 1) {
						g[i][j] = 1;
						g[j][i] = 1;
					}
				}
			}
		}

		bfs();
		return answer;
	}

	public void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.addLast(new int[] { 0, 0 });

		while (!dq.isEmpty()) {
			int[] cur = dq.removeFirst();

			if (visited[cur[0]])
				continue;

			if (cur[0] != 0 && words[cur[0] - 1].equals(target)) {
				answer = cur[1];
				return;
			}

			visited[cur[0]] = true;
			for (int i = 0; i <= n; i++) {
				if (g[cur[0]][i] != 1)
					continue;
				if (visited[i])
					continue;

				dq.addLast(new int[] { i, cur[1] + 1 });

			}
		}
	}
}