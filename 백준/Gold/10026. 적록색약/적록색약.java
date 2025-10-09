import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[][] notBlindG;
    static char[][] blindG;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int isNotBlindCnt;
    static int isBlindCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        notBlindG = new char[n][n];
        blindG = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                notBlindG[i][j] = line.charAt(j);
                if (line.charAt(j) == 'G') blindG[i][j] = 'R';
                else blindG[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    isNotBlindCnt++;
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    isdfs(i, j);
                    isBlindCnt++;
                }
            }
        }
        System.out.println(isNotBlindCnt + " " + isBlindCnt);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visited[nx][ny]) continue;

            if (notBlindG[x][y] == notBlindG[nx][ny]) dfs(nx, ny);
        }
    }

    static void isdfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visited[nx][ny]) continue;

            if (blindG[x][y] == blindG[nx][ny]) isdfs(nx, ny);
        }
    }
}