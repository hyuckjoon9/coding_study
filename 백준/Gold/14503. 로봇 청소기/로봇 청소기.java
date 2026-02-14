import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cleaningCount = 0;
        while (true) {
            if (board[r][c] != 2) cleaningCount++;
            board[r][c] = 2;

            if (dirtyAround(r, c, d)) {
                for (int i = 0; i < 4; i++) {
                    d = (d + 3) % 4;

                    int nr = r + dx[d];
                    int nc = c + dy[d];

                    if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1) continue;

                    if (board[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        break;
                    }
                }
            } else {
                int nd = (d + 2) % 4;

                int nr = r + dx[nd];
                int nc = c + dy[nd];

                if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1 || board[nr][nc] == 1) {
                    break;
                }
                r = nr;
                c = nc;
            }
        }
        System.out.println(cleaningCount);
    }

    public static boolean dirtyAround(int r, int c, int d) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            d = (d + 3) % 4;

            if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1) continue;
            if (board[nr][nc] == 0) return true;
        }
        return false;
    }

}