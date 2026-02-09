import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 1_000_000_000;
    static List<Node>[] g;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        g = new ArrayList[N + 1];
        weight = new int[N + 1];
        Arrays.fill(weight, -1);

        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[u].add(new Node(v, w));
            g[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        path(start);
        System.out.println(weight[end]);
    }

    static public void path(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.weight, a.weight));
        pq.add(new Node(start, INF));
        weight[start] = INF;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight < weight[cur.to]) continue;

            for (Node next : g[cur.to]) {
                int candidate = Math.min(weight[cur.to], next.weight);
                if (candidate > weight[next.to]) {
                    weight[next.to] = candidate;
                    pq.add(new Node(next.to, candidate));
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
}