import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	class Node {
		int to;
		int weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public int solution(int N, int[][] road, int K) {
		int answer = 0;
		List<Node>[] g = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			g[i] = new ArrayList<>();
		}

		for (int i = 0; i < road.length; i++) {
			int from = road[i][0];
			int to = road[i][1];
			int weight = road[i][2];
			g[from].add(new Node(to, weight));
			g[to].add(new Node(from, weight));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a.weight, b.weight);
		});

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

		pq.add(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.to] < cur.weight)
				continue;

			for (Node next : g[cur.to]) {
				int nextWeight = dist[cur.to] + next.weight;

				if (nextWeight < dist[next.to]) {
					dist[next.to] = nextWeight;
					pq.add(new Node(next.to, nextWeight));
				}
			}
		}

		for (int d : dist) {
			if (d <= K)
				answer++;
		}
		return answer;
	}
}