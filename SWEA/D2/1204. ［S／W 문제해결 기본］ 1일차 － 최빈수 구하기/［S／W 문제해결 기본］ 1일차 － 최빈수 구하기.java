import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			int[] scores = new int[101];
			int maxIdx = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				scores[score]++;
				if (scores[maxIdx] <= scores[score]) {
					maxIdx = score;
				}
			}

			sb.append("#").append(test_case).append(" ").append(maxIdx).append("\n");
		}
		System.out.print(sb);
	}
}