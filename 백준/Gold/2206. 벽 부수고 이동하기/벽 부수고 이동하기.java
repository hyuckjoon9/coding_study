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
    static int[][][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1][2];

        dist[1][1][0] = 1;
        dist[1][1][1] = 1;

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = line.charAt(j - 1) - '0';
            }
        }


        bfs();
    }

    public static void bfs() {
        Deque<Pair> dq = new ArrayDeque<>();
        dq.addLast(new Pair(1, 1, 0));

        while (!dq.isEmpty()) {
            Pair cur = dq.pollFirst();

            if (cur.x == N && cur.y == M) {
                System.out.println(dist[cur.x][cur.y][cur.broke]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int broke = cur.broke;

                if (nx <= 0 || ny <= 0 || nx > N || ny > M) continue;

                if (board[nx][ny] == 0) {
                    if (dist[nx][ny][broke] == 0) {
                        dist[nx][ny][broke] = dist[cur.x][cur.y][cur.broke] + 1;
                        dq.addLast(new Pair(nx, ny, broke));
                    }
                } else {
                    if (broke == 0 && dist[nx][ny][broke] == 0) {
                        dist[nx][ny][1] = dist[cur.x][cur.y][cur.broke] + 1;
                        dq.addLast(new Pair(nx, ny, 1));
                    }

                }
            }
        }
        System.out.println(-1);
    }

    public static class Pair {
        int x;
        int y;
        int broke;

        Pair(int x, int y, int broke) {
            this.x = x;
            this.y = y;
            this.broke = broke;
        }
    }
}
