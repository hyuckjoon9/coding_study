import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int blue;
	static int white;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		tokenBoard(0, 0, N);
		System.out.print(white + "\n" + blue);

	}

	public static void tokenBoard(int row, int col, int N) {
		if (N == 0)
			return;
		if (checkNum(row, col, N))
			return;

		tokenBoard(row, col, N / 2);
		tokenBoard(row, col + N / 2, N / 2);
		tokenBoard(row + N / 2, col, N / 2);
		tokenBoard(row + N / 2, col + N / 2, N / 2);
	}

	public static boolean checkNum(int row, int col, int N) {
		int sum = 0;
		for (int i = row; i < row + N; i++) {
			for (int j = col; j < col + N; j++) {
				sum += board[i][j];
			}
		}

		if (sum == N * N) {
			blue++;
			return true;
		} else if (sum == 0) {
			white++;
			return true;
		}

		return false;
	}

}

