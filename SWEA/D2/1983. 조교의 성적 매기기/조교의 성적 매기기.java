import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			double kTotal = 0;

			String[] score = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

			Double[] arr = new Double[n + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				int sc1 = Integer.parseInt(st.nextToken());
				int sc2 = Integer.parseInt(st.nextToken());
				int sc3 = Integer.parseInt(st.nextToken());

				double total = sc1 * 0.35 + sc2 * 0.45 + sc3 * 0.2;
				if (i == k)
					kTotal = total;
				arr[i] = total;
			}
			arr[0] = 0.0;
			Arrays.sort(arr, Collections.reverseOrder());

			int kIdx = 0;
			for (int i = 1; i <= n; i++) {
				if (arr[i] == kTotal)
					kIdx = i;
			}
			int ratio = n / 10;

			sb.append("#").append(test_case).append(" ").append(score[kIdx / ratio]).append("\n");

		}
		System.out.print(sb);
	}
}