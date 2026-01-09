import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
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
    static Deque<Pair> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], 1);
        }

        visited = new boolean[N][M];
        dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    dq.addLast(new Pair(i, j));
                } else if (board[i][j] == -1) dist[i][j] = -1;
            }
        }

        bfs();
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, dist[i][j]);
            }
        }

        System.out.println(answer - 1);
    }

    public static void bfs() {

        while (!dq.isEmpty()) {
            Pair cur = dq.pollFirst();

            if (visited[cur.x][cur.y]) continue;

            visited[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (board[nx][ny] != 0) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                board[nx][ny] = 1;
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