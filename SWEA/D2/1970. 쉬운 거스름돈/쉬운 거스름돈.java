import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		int[] arr = { 50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10 };
		for (int test_case = 1; test_case <= T; test_case++) {
			int money = Integer.parseInt(br.readLine());
			int[] count = new int[8];

			for (int i = 0; i < 8; i++) {
				if (money / arr[i] == 0) {
					continue;
				}
				count[i] = money / arr[i];
				money -= arr[i] * count[i];
			}

			sb.append("#").append(test_case).append("\n");
			for (int v : count) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}