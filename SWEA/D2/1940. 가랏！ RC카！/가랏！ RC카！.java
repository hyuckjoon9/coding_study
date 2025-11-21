import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());

			int dist = 0;
			int curSpeed = 0;
			int[] commands = { 0, 1, -1 };
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int speed = 0;
				if (command != 0) {
					speed = Integer.parseInt(st.nextToken());
				}

				curSpeed += commands[command] * speed;
				curSpeed = Math.max(0, curSpeed);
				dist += curSpeed;

			}
			sb.append(dist).append("\n");
		}
		System.out.print(sb);
	}
}