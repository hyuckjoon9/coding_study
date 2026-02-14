import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 1_000_000_000;
    static List<Node>[] g;
    static int[] dist;
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        g = new ArrayList[n + 1];
        dist = new int[n + 1];
        path = new int[n + 1];

        Arrays.fill(path, -1);
        Arrays.fill(dist, INF);
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g[u].add(new Node(v, w));
            g[v].add(new Node(u, w));
        }

        int[][] result = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
            result[i] = path.clone();
            Arrays.fill(path, -1);
            Arrays.fill(dist, INF);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (result[i][j] == -1) {
                    sb.append("-");
                } else {
                    sb.append(result[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void dijkstra(int start) {
        PriorityQueue<State> pq = new PriorityQueue();
        dist[start] = 0;
        pq.add(new State(start, 0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.weight > dist[cur.to]) continue;

            for (Node next : g[cur.to]) {
                int newWeight = dist[cur.to] + next.weight;
                if (dist[next.to] > newWeight) {
                    dist[next.to] = newWeight;
                    pq.add(new State(next.to, newWeight));

                    if (cur.to == start) {
                        path[next.to] = next.to;
                    } else {
                        path[next.to] = path[cur.to];
                    }

                }
            }
        }
    }


    public static class State implements Comparable<State> {
        int to;
        int weight;

        State(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(State o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}