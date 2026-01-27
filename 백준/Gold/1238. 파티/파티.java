import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 1_000_000_000;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
        }

        int[] maxDist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dijkstra(i);

            if (i == X) {
                int idx = 1;
                while (idx <= N) {
                    maxDist[idx] += dist[idx];
                    idx++;
                }
            } else {
                maxDist[i] += dist[X];
            }

            Arrays.fill(dist, INF);
        }

        int answer = 0;
        for (int v : maxDist) {
            answer = Math.max(v, answer);
        }
        System.out.println(answer);
    }

    static void dijkstra(int start) {
        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new State(start, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (dist[cur.vertex] < cur.cost) continue;

            for (Node next : graph[cur.vertex]) {
                int nextCost = next.weight + dist[cur.vertex];
                if (nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    pq.add(new State(next.to, nextCost));
                }
            }
        }
    }

    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State implements Comparable<State> {
        int vertex;
        int cost;

        State(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(State o) {
            return this.cost - o.cost;
        }
    }
}