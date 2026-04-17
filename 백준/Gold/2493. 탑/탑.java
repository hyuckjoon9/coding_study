
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
//			int num = Integer.parseInt(st.nextToken());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] answer = new int[N + 1];
		Deque<Integer> dq = new ArrayDeque<>();
		dq.addLast(N);

		for (int i = N - 1; i >= 1; i--) {
			while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
				answer[dq.removeLast()] = i;
			}

			dq.addLast(i);
		}

		while (!dq.isEmpty()) {
			answer[dq.removeLast()] = 0;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append(" ");

		}
        System.out.println(sb);
	}

}
