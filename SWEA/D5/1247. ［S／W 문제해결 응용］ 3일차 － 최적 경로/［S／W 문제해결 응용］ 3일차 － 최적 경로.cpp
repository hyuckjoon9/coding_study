import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] customers;
	static int N;
	static int minDist;
	static int companyX;
	static int companyY;
	static int homeX;
	static int homeY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			customers = new int[N][2];
			minDist = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());

			companyX = Integer.parseInt(st.nextToken());
			companyY = Integer.parseInt(st.nextToken());

			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				customers[i][0] = x;
				customers[i][1] = y;
			}

			dfs(0, 0, companyX, companyY, 0);

			sb.append("#").append(test_case).append(" ").append(minDist).append("\n");


		}
		System.out.println(sb);
	}

	public static void dfs(int depth, int visited, int curX, int curY, int dist) {
		if (dist >= minDist)
			return;

		if (depth == N) {
			dist += Math.abs(homeX - curX) + Math.abs(homeY - curY);
			minDist = Math.min(minDist, dist);
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0)
				continue;

			int nextX = customers[i][0];
			int nextY = customers[i][1];

			int nextDist = Math.abs(customers[i][0] - curX) + Math.abs(customers[i][1] - curY) + dist;

			dfs(depth + 1, visited | (1 << i), nextX, nextY, nextDist);
		}
	}

}