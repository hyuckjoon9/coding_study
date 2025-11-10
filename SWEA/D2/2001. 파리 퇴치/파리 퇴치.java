import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] pSum = new int[N + 1][N + 1];

			for (int row = 1; row <= N; row++) {
				for (int col = 1; col <= N; col++) {
					pSum[row][col] = arr[row][col] + pSum[row - 1][col] + pSum[row][col - 1] - pSum[row - 1][col - 1];

				}
			}
			int maxSum = 0;
			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					int sum = pSum[i][j] - pSum[i][j - M] - pSum[i - M][j] + pSum[i - M][j - M];
					maxSum = Math.max(maxSum, sum);
				}
			}

			sb.append("#").append(test_case).append(" ").append(maxSum).append("\n");
		}
		System.out.print(sb);
	}
}