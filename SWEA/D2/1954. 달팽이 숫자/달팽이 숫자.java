import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];
			int num = 1;
			int row = 0;
			int col = 0;
			int rowBlock = 0;
			int colBlock = 0;

			while (num <= (N * N)) {
				for (int i = col; i < N - colBlock; i++) {
					arr[row][i] = num++;
					col = i;
				}
				row++;
				for (int i = row; i < N - rowBlock; i++) {
					arr[i][col] = num++;
					row = i;
				}
				col--;
				for (int i = col; i >= colBlock; i--) {
					arr[row][i] = num++;
					col = i;
				}
				row--;
				for (int i = row; i > rowBlock; i--) {
					arr[i][col] = num++;
					row = i;
				}
				col++;

				colBlock++;
				rowBlock++;

			}

			sb.append("#").append(test_case).append("\n");
			for (int[] vArr : arr) {
				for (int v : vArr) {
					sb.append(v);
					if (v != vArr[vArr.length - 1])
						sb.append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}