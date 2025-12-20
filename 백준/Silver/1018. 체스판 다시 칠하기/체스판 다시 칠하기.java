import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }


        int minWrong = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int blackWrong = 0;
                int whiteWrong = 0;
                for (int row = i; row < 8 + i; row++) {
                    for (int col = j; col < 8 + j; col++) {
                        if ((i + j) % 2 == 0) {
                            if ((row + col) % 2 == 0 && board[row][col] != 'B') blackWrong++;
                            if ((row + col) % 2 != 0 && board[row][col] != 'W') blackWrong++;

                            if ((row + col) % 2 == 0 && board[row][col] != 'W') whiteWrong++;
                            if ((row + col) % 2 != 0 && board[row][col] != 'B') whiteWrong++;
                        } else {
                            if ((row + col) % 2 != 0 && board[row][col] != 'B') blackWrong++;
                            if ((row + col) % 2 == 0 && board[row][col] != 'W') blackWrong++;

                            if ((row + col) % 2 != 0 && board[row][col] != 'W') whiteWrong++;
                            if ((row + col) % 2 == 0 && board[row][col] != 'B') whiteWrong++;
                        }
                    }
                }
                minWrong = Math.min(minWrong, Math.min(whiteWrong, blackWrong));
            }
        }
        System.out.println(minWrong);
    }
}