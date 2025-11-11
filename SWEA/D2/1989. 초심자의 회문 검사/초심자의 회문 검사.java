import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			Deque<Character> dq = new ArrayDeque<>();

			for (int i = 0; i < str.length(); i++) {
				dq.add(str.charAt(i));
			}

			boolean isPd = true;
			while (!dq.isEmpty() && dq.size() != 1) {
				if (dq.peekFirst() != dq.peekLast()) {
					isPd = false;
					break;
				}
				dq.removeFirst();
				dq.removeLast();
			}

			sb.append("#").append(test_case).append(" ").append(isPd ? 1 : 0).append("\n");
		}
		System.out.print(sb);
	}
}