import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {

			int[][] board = new int[9][9];
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean check = true;

			for (int i = 0; i < 9; i++) {
				check = checkLine(board[i]);
				if (!check) {
					break;
				}
			}
			if (!check) {
				sb.append("#").append(test_case).append(" ").append("0").append("\n");
				continue;
			}

			for (int i = 0; i < 9; i++) {
				int[] colArr = new int[9];
				for (int j = 0; j < 9; j++) {
					colArr[j] = board[j][i];
				}
				check = checkLine(colArr);
				if (!check) {
					break;
				}
			}
			if (!check) {
				sb.append("#").append(test_case).append(" ").append("0").append("\n");
				continue;
			}

			int[][] box = new int[3][3];
			check = true;

			for (int i = 0; i < 9; i += 3) {

				for (int j = 0; j < 9; j += 3) {
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
							box[r][c] = board[i + r][j + c];
						}
					}
					check = checkBox(box);
					if (!check) {
						break;
					}
				}
				if (!check) {
					break;
				}
			}
			if (!check) {
				sb.append("#").append(test_case).append(" ").append("0").append("\n");
				continue;
			}

			sb.append("#").append(test_case).append(" ").append("1").append("\n");

		}
		System.out.print(sb);
	}

	public static boolean checkLine(int[] line) {
		boolean[] checkNum = new boolean[9];
		for (int i = 0; i < 9; i++) {
			checkNum[line[i] - 1] = true;
		}

		for (int i = 0; i < 9; i++) {
			if (!checkNum[i])
				return false;
		}
		return true;
	}

	public static boolean checkBox(int[][] box) {
		boolean[] checkNum = new boolean[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				checkNum[box[i][j] - 1] = true;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (!checkNum[i])
				return false;
		}
		return true;

	}
}