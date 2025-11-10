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

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxSum = 0;
			for (int i = 0; i <= (N - M); i++) {
				for (int j = 0; j <= (N - M); j++) {
					int sum = 0;
					for (int mRow = 0; mRow < M; mRow++) {
						for (int mCol = 0; mCol < M; mCol++) {							
							sum += arr[i + mRow][j + mCol];
						}
					}
					maxSum = Math.max(maxSum, sum);
				}
			}

			sb.append("#").append(test_case).append(" ").append(maxSum).append("\n");
		}
		System.out.print(sb.toString());
	}
}