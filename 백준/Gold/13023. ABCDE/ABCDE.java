import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] g;
    static boolean[] visited;
    static int n;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        g = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g[a].add(b);
            g[b].add(a);
        }


        for (int i = 0; i < n; i++) {
            if (!visited[i]) dfs(i, 1);
        }
        System.out.println(arrive ? 1 : 0);

    }

    static void dfs(int node, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[node] = true;
        for (int next : g[node]) {
            if (!visited[next]) dfs(next, depth + 1);
        }
        visited[node] = false;
    }
}