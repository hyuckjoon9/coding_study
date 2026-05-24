import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			int[] d = new int[n];
			int[] t = new int[n];
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				d[i] = Integer.parseInt(st.nextToken());
				t[i] = Integer.parseInt(st.nextToken());
				pq.add(new int[] { i, t[i] });
			}

			int lastTime = Integer.MAX_VALUE;
			while (!pq.isEmpty()) {
				int[] next = pq.poll();

				lastTime = Math.min(lastTime, next[1]);
				lastTime -= d[next[0]];
			}
			sb.append(lastTime).append("\n");
		}
		System.out.println(sb);
	}
}