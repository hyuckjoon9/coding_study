import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int k;

    static char[][] board;
    static boolean[][] visited;

    static int size;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = '#';
        }

        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && board[i][j] == '#') {
                    size = dfs(i, j);
                    maxSize = Math.max(size, maxSize);
                }
            }
        }
        System.out.println(maxSize);
    }

    static int dfs(int x, int y) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        visited[x][y] = true;
        int count = 0;

        stack.push(new int[]{x, y});
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cx = cur[0];
            int cy = cur[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx <= 0 || ny <= 0 || nx > n || ny > m) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] != '#') continue;

                stack.push(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        return count;
    }
}