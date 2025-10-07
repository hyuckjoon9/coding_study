import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] g;
    static boolean[][] visited;
    static int width;
    static int height;
    static int cnt;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());


            if (width == 0 && height == 0) return;

            g = new int[height][width];
            visited = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    g[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cnt = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!visited[i][j] && g[i][j] == 1) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int d = 0; d < 8; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx < 0 || ny < 0 || nx >= height || ny >= width) continue;
            if (visited[nx][ny] || g[nx][ny] == 0) continue;


            dfs(nx, ny);
        }

    }
}