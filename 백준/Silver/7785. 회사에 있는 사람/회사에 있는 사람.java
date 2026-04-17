import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Set<String> s = new TreeSet<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			String action = st.nextToken();

			// 출근 -> 1 , 퇴근 -> 0
			if (action.equals("enter")) {
				s.add(name);
			} else {
				s.remove(name);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String name : s) {
			sb.append(name).append("\n");
		}

		System.out.println(sb);

	}

}
