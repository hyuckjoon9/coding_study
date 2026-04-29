import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static Node[] nodes;
	static List<Node>[] list;
	static boolean[] visited;
	static int N;

	static class Node implements Comparable<Node> {
		int index;
		int x;
		int y;
		long cost;

		Node(int index, int x, int y, long cost) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			nodes = new Node[N + 1];
			int[] xs = new int[N + 1];
			int[] ys = new int[N + 1];

			list = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			visited = new boolean[N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				xs[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				ys[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				nodes[i] = new Node(i, xs[i], ys[i], 0);
			}

			double E = Double.parseDouble(br.readLine());

			for (int i = 1; i <= N - 1; i++) {
				for (int j = i + 1; j <= N; j++) {
					long dist = getDist(nodes[i], nodes[j]);
					list[i].add(new Node(nodes[j].index, nodes[j].x, nodes[j].y, dist));
					list[j].add(new Node(i, nodes[i].x, nodes[i].y, dist));
				}
			}

			long L = prim();
			long answer = Math.round(E * L);

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static public long prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, nodes[1].x, nodes[1].y, 0));

		long totalCost = 0L;
		int count = 1;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.index])
				continue;

			visited[cur.index] = true;

			totalCost += cur.cost;

			if (count++ == N)
				break;

			for (Node next : list[cur.index]) {
				if (visited[next.index])
					continue;

				pq.add(next);
			}
		}
		return totalCost;
	}

	static public long getDist(Node a, Node b) {
		long dx = (long) a.x - b.x;
		long dy = (long) a.y - b.y;

		return dx * dx + dy * dy;
	}

}
