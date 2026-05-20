import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	int[] dc = { -1, 1, 0, 0 };
	int[] dr = { 0, 0, -1, 1 };
	boolean[][] visited;
	int[][] maps;
	int n;
	int m;
	int sRow;
	int sCol;
	int eRow;
	int eCol;
	int answer;

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

		sRow = 0;
		sCol = 0;
		eRow = n - 1;
		eCol = m - 1;

		answer = 0;

		visited = new boolean[n][m];
		this.maps = maps;

		boolean flag = bfs();

		answer = flag ? answer : -1;

		return answer;
	}

	public boolean bfs() {
		Deque<Node> dq = new ArrayDeque<>();
		dq.addLast(new Node(sRow, sCol, 1));
		visited[sRow][sCol] = true;

		while (!dq.isEmpty()) {
			Node cur = dq.removeFirst();

			if (cur.r == eRow && cur.c == eCol) {
				answer = cur.dist;
				return true;
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

		return false;
	}
}
