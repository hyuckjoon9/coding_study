import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	int[] dc = { -1, 1, 0, 0 };
	int[] dr = { 0, 0, -1, 1 };

	boolean[][] visited;
	int[][] maps;
	int n;
	int m;

	public class Node {
		int r;
		int c;
		int dist;

		Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	public int solution(int[][] maps) {
		n = maps.length;
		m = maps[0].length;

		visited = new boolean[n][m];
		this.maps = maps;

		int answer = bfs();

		return answer;
	}

	public int bfs() {
		Deque<Node> dq = new ArrayDeque<>();
		dq.addLast(new Node(0, 0, 1));
		visited[0][0] = true;

		while (!dq.isEmpty()) {
			Node cur = dq.removeFirst();

			if (cur.r == n - 1 && cur.c == m - 1) {
				return cur.dist;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (visited[nr][nc] || maps[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				dq.addLast(new Node(nr, nc, cur.dist + 1));

			}
		}

		return -1;
	}
}
