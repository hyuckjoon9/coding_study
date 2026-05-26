import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	static long min;
	static int count;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			int C1 = Integer.parseInt(st.nextToken());
			int C2 = Integer.parseInt(st.nextToken());

			int[] cows = new int[N];
			int[] horses = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cows[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				horses[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(cows);
			Arrays.sort(horses);

			min = Integer.MAX_VALUE;
			count = 0;

			for (int i = 0; i < N; i++) {
				findNearZ(horses, cows[i]);
			}

			min += Math.abs(C1 - C2);
			sb.append("#").append(test_case).append(" ").append(min).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	public static void findNearZ(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {

			int mid = (left + right) / 2;

			if (arr[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		int idx = left;

		if (idx == 0) {
			int dist = Math.abs(arr[idx] - target);
			if (dist == min)
				count++;
			else if (dist < min) {
				min = dist;
				count = 1;
			}

			return;
		}

		int lowerDist = Math.abs(arr[idx - 1] - target);
		int upperDist = Math.abs(arr[idx] - target);

		if (lowerDist == upperDist) {
			int dist = upperDist;
			if (dist == min)
				count += 2;
			else if (dist < min) {
				min = dist;
				count = 2;
			}

		} else {
			if (lowerDist < upperDist)
				idx -= 1;
			int dist = Math.abs(arr[idx] - target);
			if (dist == min)
				count++;
			else if (dist < min) {
				count = 1;
				min = dist;
			}

		}
	}
}