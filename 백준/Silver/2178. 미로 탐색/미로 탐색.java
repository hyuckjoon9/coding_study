import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        dist = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = line.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);
    }

    public static void bfs(int x, int y) {
        Deque<Pair> dq = new ArrayDeque<>();
        dq.addLast(new Pair(x, y));

        while (!dq.isEmpty()) {
            Pair cur = dq.pollFirst();

            if (visited[cur.x][cur.y]) continue;
            if (cur.x == N && cur.y == M) {
                System.out.println(dist[N][M] + 1);
                return;
            }

            visited[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx > N || ny > M || nx < 1 || ny < 1) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == 0) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                dq.addLast(new Pair(nx, ny));
            }
        }
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}