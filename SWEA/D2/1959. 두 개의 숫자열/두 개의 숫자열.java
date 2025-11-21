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
			int M = Integer.parseInt(st.nextToken());

			int[] arr1 = new int[N];
			int[] arr2 = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}

			int start = 0;
			int end = Math.min(arr1.length, arr2.length) - 1;
			int maxLength = Math.max(arr1.length, arr2.length);
			int minLength = Math.min(arr1.length, arr2.length);
			int maxValue = 0;
			while (end < maxLength) {
				int sum = 0;
				int startIdx = start;
				for (int i = 0; i < minLength; i++) {
					if (maxLength == arr1.length) {
						sum += arr1[startIdx++] * arr2[i];
					} else {
						sum += arr1[i] * arr2[startIdx++];
					}

				}
				maxValue = Math.max(sum, maxValue);
				start++;
				end++;
			}

			sb.append("#").append(test_case).append(" ").append(maxValue).append("\n");
		}
		System.out.println(sb);
	}
}