import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int x) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(x);

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            if (visited[cur]) continue;

            visited[cur] = true;

            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                if (graph[cur][i] != 1) continue;
                dq.addLast(i);
            }
        }
    }
}