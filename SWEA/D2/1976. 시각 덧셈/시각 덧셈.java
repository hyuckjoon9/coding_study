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

			int firstHour = Integer.parseInt(st.nextToken());
			int firstMins = Integer.parseInt(st.nextToken());
			int secondHour = Integer.parseInt(st.nextToken());
			int secondMins = Integer.parseInt(st.nextToken());

			int resultHour = 0;
			int resultMins = 0;

			resultHour = firstHour + secondHour;
			resultMins = firstMins + secondMins;
			if (resultMins > 60) {
				resultMins -= 60;
				resultHour++;
			}
			if (resultHour > 12) {
				resultHour -= 12;
			}

			sb.append("#").append(test_case).append(" ").append(resultHour).append(" ").append(resultMins).append("\n");
		}
		System.out.print(sb);
	}
}