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
			int r = 0;
			int c = 0;

			int dir = 0;
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			for (int i = 0; i < N * N; i++) {
				arr[r][c] = num++;

				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 0) {
					dir = (dir + 1) % 4;
					nr = r + dr[dir];
					nc = c + dc[dir];
				}

				r = nr;
				c = nc;
			}

			sb.append("#").append(test_case).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]);
					if (j != N - 1) {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}