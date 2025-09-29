import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int target1;
    static int target2;
    static boolean[] visited;
    static ArrayList<Integer>[] g;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        g = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            g[u].add(v);
            g[v].add(u);
        }

        dfs(target1, 0);
        if (!check) System.out.println(-1);
    }

    static void dfs(int node, int depth) {
        if (visited[node]) return;
        if (node == target2) {
            check = true;
            System.out.println(depth);
            return;
        }

        visited[node] = true;
        for (int next : g[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }

    }
}