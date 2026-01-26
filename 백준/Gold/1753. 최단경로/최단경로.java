import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static List<Node>[] g;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        g = new ArrayList[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            dist[i] = INF;
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");

        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.vertex] < cur.cost) continue;

            for (Node next : g[cur.vertex]) {
                int newCost = next.cost + dist[cur.vertex];
                if (newCost < dist[next.vertex]) {
                    dist[next.vertex] = newCost;
                    pq.add(new Node(next.vertex, newCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}