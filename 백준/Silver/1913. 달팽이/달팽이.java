import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());

        int[][] board = new int[N + 1][N + 1];

        int x = N / 2 + 1;
        int y = N / 2 + 1;
        board[x][y] = 1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int move = 1;
        int dir = 0;

        int fx = x;
        int fy = y;

        int num = 1;

        while (num < N * N) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < move; j++) {
                    if (num == N * N) break;

                    x = x + dx[dir];
                    y = y + dy[dir];

                    board[x][y] = ++num;

                    if (num == find) {
                        fx = x;
                        fy = y;
                    }
                }
                dir = (dir + 1) % 4;
            }
            move++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(fx).append(" ").append(fy);
        System.out.println(sb);
    }
}