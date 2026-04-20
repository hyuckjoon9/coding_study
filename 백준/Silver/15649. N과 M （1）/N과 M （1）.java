import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int M;
	static int N;
	static int[] arr;
	static int[] answer;
	static StringBuilder sb;

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		answer = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();

		permutation(0);

		System.out.println(sb);
	}

	public static void permutation(int depth) {
		if (depth == M) {
			for (int v : answer) {
				sb.append(v).append(" ");

			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			answer[depth] = arr[i];

			permutation(depth + 1);
			visited[i] = false;
		}
	}
}