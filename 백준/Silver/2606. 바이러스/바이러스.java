import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int computers;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computers = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        graph = new int[computers + 1][computers + 1];
        visited = new boolean[computers + 1];

        for (int i = 0; i < edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        bfs(1);
    }

    public static void bfs(int v) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(v);

        int count = 0;
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            if (visited[cur]) continue;
            count++;
            visited[cur] = true;

            for (int i = 1; i <= computers; i++) {
                if (visited[i]) continue;
                if (graph[cur][i] != 1) continue;

                dq.addLast(i);
            }
        }
        System.out.println(count - 1);
    }
}