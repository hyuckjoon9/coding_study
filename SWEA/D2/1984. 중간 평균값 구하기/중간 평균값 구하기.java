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

			int min = 0;
			int max = 0;
			double sum = 0;

			for (int i = 0; i < 10; i++) {
				int n = Integer.parseInt(st.nextToken());
				if (i == 0) {
					min = n;
					max = n;
					continue;
				}

				if (min > n) {
					if (max != min)
						sum += min;
					min = n;
				} else if (max < n) {
					if (max != min)
						sum += max;
					max = n;
				} else {
					sum += n;
				}
			}
			sb.append("#").append(test_case).append(" ").append(Math.round(sum / 8)).append("\n");

		}
		System.out.print(sb);
	}
}