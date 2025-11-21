import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		int[] MONTH = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int fm = Integer.parseInt(st.nextToken());
			int fd = Integer.parseInt(st.nextToken());
			int sm = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());

			int sum = 0;

			while (fm < sm) {
				sum += MONTH[fm++];
			}
			sum = sum + sd - fd + 1;
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}