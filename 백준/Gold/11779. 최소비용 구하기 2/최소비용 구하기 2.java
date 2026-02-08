import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] g;
    static int[] dist;
    static int[] prev;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        g = new ArrayList[n + 1];
        dist = new int[n + 1];
        prev = new int[n + 1];

        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");

        List<Integer> order = new ArrayList<>();

        int cur = end;

        while (cur != -1) {
            order.add(cur);
            cur = prev[cur];
        }

        Collections.reverse(order);

        sb.append(order.size()).append("\n");
        for (Integer v : order) {
            sb.append(v).append(" ");
        }

        System.out.println(sb);

    }

    static public void dijkstra(int start) {
        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new State(start, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.cost > dist[cur.vertex]) continue;

            for (Node next : g[cur.vertex]) {
                int newCost = next.weight + dist[cur.vertex];
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    prev[next.to] = cur.vertex;
                    pq.add(new State(next.to, newCost));
                }
            }
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

    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}