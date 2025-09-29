import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] visited;
    static ArrayList<Integer>[] g;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        g = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            g[u].add(v);
            g[v].add(u);
        }
        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int node) {
        if (visited[node]) return;

        visited[node] = true;
        for (int next : g[node]) {
            if (!visited[next]) {
                cnt++;
                dfs(next);
            }
        }
    }
}