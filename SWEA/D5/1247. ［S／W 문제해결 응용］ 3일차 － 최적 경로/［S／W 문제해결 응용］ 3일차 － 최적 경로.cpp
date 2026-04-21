import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<int[]> cust;
	static int[][] permutes;
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
			permutes = new int[N][2];
			minDist = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());

			companyX = Integer.parseInt(st.nextToken());
			companyY = Integer.parseInt(st.nextToken());

			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());

			cust = new ArrayList();
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cust.add(new int[] { x, y });
			}

			permutation(0, 0);

			sb.append("#").append(test_case).append(" ").append(minDist).append("\n");


		}
		System.out.println(sb);
	}

	public static void permutation(int depth, int flag) {
		if (depth == N) {
			int dist = 0;
			dist += Math.abs(companyX - permutes[0][0]) + Math.abs(companyY - permutes[0][1]);
			dist += Math.abs(homeX - permutes[permutes.length - 1][0])
					+ Math.abs(homeY - permutes[permutes.length - 1][1]);
			for (int i = 0; i < permutes.length - 1; i++) {
				int distX = Math.abs(permutes[i][0] - permutes[i + 1][0]);
				int distY = Math.abs(permutes[i][1] - permutes[i + 1][1]);
				dist += distX + distY;
			}
			minDist = Math.min(dist, minDist);

			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) != 0)
				continue;
			permutes[depth] = cust.get(i);
			permutation(depth + 1, flag | (1 << i));
		}
	}

}