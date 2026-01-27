import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] graph;
    static int INF = 1_000_000_000;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int path1 = INF;
        int path2 = INF;

        dijkstra(1);
        int a1 = dist[v1];
        int a2 = dist[v2];

        Arrays.fill(dist, INF);
        dijkstra(v1);
        int b1 = dist[v2];
        int b2 = dist[N];

        Arrays.fill(dist, INF);
        dijkstra(v2);
        int c1 = dist[N];
        int c2 = dist[v1];

        if (a1 < INF && b1 < INF && c1 < INF) {
            path1 = a1 + b1 + c1;
        }
        if (a2 < INF && c2 < INF && b2 < INF) {
            path2 = a2 + c2 + b2;
        }

        if (path1 >= INF && path2 >= INF) System.out.println(-1);
        else System.out.println(Math.min(path1, path2));
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