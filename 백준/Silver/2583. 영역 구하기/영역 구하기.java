import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] g;
    static boolean[][] visited;
    static int n;
    static int m;
    static int k;
    static int cnt;
    static ArrayList<Integer> area;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        g = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = 1;
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = n - Integer.parseInt(st.nextToken()) - 1;
            int rightX = Integer.parseInt(st.nextToken()) - 1;
            int rightY = n - Integer.parseInt(st.nextToken());
            for (int k = rightY; k <= leftY; k++) {
                for (int t = leftX; t <= rightX; t++) {
                    g[k][t] = 0;
                }
            }
        }
        area = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    area.add(dfs(i, j));
                }
            }
        }
        System.out.println(cnt);
        area.sort((a, b) -> a - b);
        for (int i : area) System.out.print(i + " ");
    }

    static int dfs(int row, int col) {
        visited[row][col] = true;
        int localArea = 1;

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (visited[nx][ny] || g[nx][ny] == 0) continue;

            localArea += dfs(nx, ny);
        }

        return localArea;
    }
}