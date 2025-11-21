import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			// N = 2^a x 3^b x 5^c x 7^d x 11^e
			int N = Integer.parseInt(br.readLine());

			int[] prime = { 2, 3, 5, 7, 11 };
			int[] cnt = new int[5];

			for (int i = 0; i < 5; i++) {
				if (N % prime[i] != 0) {
					continue;
				}
				while (N != 1 && N % prime[i] == 0) {
					N /= prime[i];
					cnt[i]++;
				}
			}

			for (int i = 0; i < cnt.length; i++) {
				sb.append(cnt[i]);
				if (i < cnt.length - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}