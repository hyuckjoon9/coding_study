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
			int K = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];
			int[][] colArr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					arr[i][j] = num;
					colArr[j][i] = num;
				}
			}

			int total = 0;
			for (int i = 0; i < N; i++) {
				total += countLine(arr[i], K);
				total += countLine(colArr[i], K);
			}
			sb.append("#").append(test_case).append(" ").append(total).append("\n");
		}
		System.out.print(sb);

	}

	public static int countLine(int[] line, int k) {
		int total = 0;

		int cnt = 0;
		for (int i = 0; i < line.length; i++) {
			if (line[i] != 1) {
				if (cnt == k)
					total++;
				cnt = 0;
			} else {
				cnt++;
				if (i == line.length - 1 && cnt == k)
					total++;
			}
		}
		return total;
	}
}