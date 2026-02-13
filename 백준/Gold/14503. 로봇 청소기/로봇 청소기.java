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

        board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 0은 청소해야 됨. 1은 벽이 있음. 2는 청소 됨.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int countCleaning = 0;

        while (true) {
            if (checkCurrent(r, c)) {
                if (checkAround(r, c)) {
                    if (checkBackOneStep(r, c, d)) {
                        int moveD = (d + 2) % 4;
                        int nr = r + dx[moveD];
                        int nc = c + dy[moveD];

                        r = nr;
                        c = nc;
                    } else {
                        break;
                    }
                } else {
                    d = getDirtyDirect(r, c, d);
                    int nr = r + dx[d];
                    int nc = c + dy[d];

                    r = nr;
                    c = nc;
                }
            } else {
                board[r][c] = 2;
                countCleaning++;
            }
        }

        System.out.println(countCleaning);
    }


    public static boolean checkAround(int r, int c) {
        return (c + 1 > M - 1 || board[r][c + 1] != 0) &&
                (c - 1 < 0 || board[r][c - 1] != 0) &&
                (r - 1 < 0 || board[r - 1][c] != 0) &&
                (r + 1 > N - 1 || board[r + 1][c] != 0);
    }

    public static boolean checkCurrent(int r, int c) {
        return board[r][c] == 2;
    }

    public static boolean checkBackOneStep(int r, int c, int d) {
        d = (d + 2) % 4;
        int nr = r + dx[d];
        int nc = c + dy[d];
        return (0 <= nr) && (nr <= (N - 1)) && (0 <= nc) && (nc <= (M - 1)) && (board[nr][nc] != 1);
    }

    public static int getDirtyDirect(int r, int c, int d) {
        int rotateCount = 0;
        while (++rotateCount <= 4) {
            d = (d + 3) % 4;
            int nr = r + dx[d];
            int nc = c + dy[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M || board[nr][nc] != 0) continue;

            break;
        }
        return d;
    }
}