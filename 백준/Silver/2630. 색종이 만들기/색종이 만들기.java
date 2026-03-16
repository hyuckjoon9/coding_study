import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int zeroCount = 0;
    static int oneCount = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        StringBuilder sb = new StringBuilder();
        if (isSameNum(board, 0, 0, N)) {
            sb.append(zeroCount).append("\n").append(oneCount);
            System.out.println(sb);
            return;
        }

        tokenizeBoard(board, 0, 0, N);

        sb.append(zeroCount).append("\n").append(oneCount);
        System.out.println(sb);

    }

    static void tokenizeBoard(int[][] board, int startRow, int startCol, int length) {
        if (length <= 0) return;
        if (isSameNum(board, startRow, startCol, length)) return;

        tokenizeBoard(board, startRow, startCol, length / 2);
        tokenizeBoard(board, startRow, startCol + length / 2, length / 2);
        tokenizeBoard(board, startRow + length / 2, startCol, length / 2);
        tokenizeBoard(board, startRow + length / 2, startCol + length / 2, length / 2);
    }

    static boolean isSameNum(int[][] board, int startRow, int startCol, int length) {
        boolean allZero = true;
        boolean allOne = true;

        int endRow = length + startRow;
        int endCol = length + startCol;
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (board[i][j] == 1) {
                    allZero = false;
                } else if (board[i][j] == 0) {
                    allOne = false;
                }
            }
        }

        if (allZero) {
            zeroCount++;
            return true;
        }
        if (allOne) {
            oneCount++;
            return true;
        }
        return false;
    }
}