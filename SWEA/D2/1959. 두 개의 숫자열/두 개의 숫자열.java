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

			int[] shortArr, longArr;
			if (N > M) {
				longArr = arr1;
				shortArr = arr2;
			} else {
				longArr = arr2;
				shortArr = arr1;
			}

			int maxSum = 0;
			for (int shift = 0; shift <= longArr.length - shortArr.length; shift++) {
				int sum = 0;
				for (int i = 0; i < shortArr.length; i++) {
					sum += shortArr[i] * longArr[i + shift];
				}
				maxSum = Math.max(maxSum, sum);
			}

			sb.append("#").append(test_case).append(" ").append(maxSum).append("\n");
		}
		System.out.println(sb);
	}
}