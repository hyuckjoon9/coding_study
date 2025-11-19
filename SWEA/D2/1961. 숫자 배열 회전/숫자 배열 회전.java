import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					arr[i][j] = num;
				}
			}
			sb.append("#").append(test_case).append("\n");
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < 3; k++) {
					for (int j = 0; j < N; j++) {
						// 90 도
						// arr[N - j - 1][i]

						// 180도
						// arr[N-i-1][N-j-1]

						// 270도
						// arr[j][N-i-1]
						if (k == 0) {
							sb.append(arr[N - j - 1][i]);
						} else if (k == 1) {
							sb.append(arr[N - i - 1][N - j - 1]);
						} else if (k == 2) {
							sb.append(arr[j][N - i - 1]);
						}
					}
					sb.append(" ");
				}
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}
}