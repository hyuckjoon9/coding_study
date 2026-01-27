import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int INF = 1_000_000_000;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N + 1];
        List<Node>[] reverse = new ArrayList[N + 1];
        int[] distFromX = new int[N + 1];
        int[] distToX = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
            distFromX[i] = INF;
            distToX[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            reverse[to].add(new Node(from, weight));
        }

        dijkstra(X, distFromX, graph);
        dijkstra(X, distToX, reverse);

        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            maxDist = Math.max(distFromX[i] + distToX[i], maxDist);
        }
        System.out.println(maxDist);
    }

    static void dijkstra(int start, int[] dist, List<Node>[] graph) {
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