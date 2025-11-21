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
			sb.append("#").append(test_case).append("\n");

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String ci = st.nextToken();
				int ki = Integer.parseInt(st.nextToken());

				while (cnt < 10 && ki > 0) {
					sb.append(ci);
					cnt++;
					ki--;
					if (cnt == 10) {
						cnt = 0;
						sb.append("\n");
					}
				}
			}
            sb.append("\n");

		}
		System.out.println(sb);
	}
}