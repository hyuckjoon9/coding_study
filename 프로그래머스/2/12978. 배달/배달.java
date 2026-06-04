import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	int N;
	int K;
	int[][] road;
	List<Node>[] graph;
	int[] dist;

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
		this.N = N;
		this.K = K;
		this.road = road;
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < road.length; i++) {
			int from = road[i][0];
			int to = road[i][1];
			int weight = road[i][2];

			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}
		dist[1] = 0;
		dijkstra(1);

		for (int d : dist) {
			if (d <= K)
				answer++;
		}

		return answer;
	}

	public void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.weight > dist[cur.to])
				continue;

			for (Node next : graph[cur.to]) {
				int nextDist = dist[cur.to] + next.weight;

				if (nextDist < dist[next.to]) {
					dist[next.to] = nextDist;
					pq.add(new Node(next.to, nextDist));
				}
			}
		}
	}
}