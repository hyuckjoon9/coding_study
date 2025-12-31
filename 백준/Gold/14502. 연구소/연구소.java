import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;
    static int maxArea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(board, 0);
        System.out.println(maxArea);
    }

    public static void dfs(int[][] board, int count) {
        if (count == 3) {
            int[][] copy = new int[N + 1][M + 1];
            for (int i = 0; i < board.length; i++) {
                copy[i] = Arrays.copyOf(board[i], board[i].length);
            }

            bfs(copy);

            int area = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (copy[i][j] == 0) area++;
                }
            }

            maxArea = Math.max(area, maxArea);
            return;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(board, count + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(int[][] board) {
        Deque<Pair> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] == 2) dq.addLast(new Pair(i, j));
            }
        }

        while (!dq.isEmpty()) {
            Pair cur = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (board[nx][ny] == 1 || board[nx][ny] == 2) continue;
                dq.addLast(new Pair(nx, ny));
                board[nx][ny] = 2;
            }
        }
    }

}

class Pair {
    int x;
    int y;

    Pair(int first, int second) {
        this.x = first;
        this.y = second;
    }
}