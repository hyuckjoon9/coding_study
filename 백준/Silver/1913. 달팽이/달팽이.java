import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());

        int[][] board = new int[N + 1][N + 1];

        int n = (N - 1) / 2;
        Coordinate one = new Coordinate(n + 1, n + 1);
        Coordinate findC = new Coordinate(0, 0);

        board[one.x][one.y] = 1;
        Coordinate prev = new Coordinate(one.x, one.y);
        int num = 2;

        for (int i = 0; i < n; i++) {
            prev.x = prev.x - 1;
            for (int j = 0; j < 4; j++) {
                if (j == 1) prev.x = prev.x + 1;
                else if (j == 2) prev.y = prev.y - 1;
                else if (j == 3) prev.x = prev.x - 1;

                for (int k = 0; k < (2 * i + 2); k++) {
                    if (j == 0) {
                        if (k != 0) prev.y = prev.y + 1;
                        if (find == num) {
                            findC.x = prev.x;
                            findC.y = prev.y;
                        }
                        board[prev.x][prev.y] = num++;
                    } else if (j == 1) {
                        if (k != 0) prev.x = prev.x + 1;
                        if (find == num) {
                            findC.x = prev.x;
                            findC.y = prev.y;
                        }
                        board[prev.x][prev.y] = num++;

                    } else if (j == 2) {
                        if (k != 0) prev.y = prev.y - 1;
                        if (find == num) {
                            findC.x = prev.x;
                            findC.y = prev.y;
                        }
                        board[prev.x][prev.y] = num++;
                    } else {
                        if (k != 0) prev.x = prev.x - 1;
                        if (find == num) {
                            findC.x = prev.x;
                            findC.y = prev.y;
                        }
                        board[prev.x][prev.y] = num++;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        if (find == 1) sb.append(n + 1).append(" ").append(n + 1);
        else sb.append(findC.x).append(" ").append(findC.y);
        System.out.println(sb);

    }


    public static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}