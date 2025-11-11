import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;

			for (int i = 1; i <= N; i++) {
				sum += (i % 2 != 0) ? i : (-1 * i);
			}

			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
	}
}