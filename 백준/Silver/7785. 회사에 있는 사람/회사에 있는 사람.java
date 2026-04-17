import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> m = new HashMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			String mode = st.nextToken();

			// 출근 -> 1 , 퇴근 -> 0
			if (mode.equals("enter")) {
				m.put(name, 1); // 출근
			} else {
				m.put(name, 0); // 퇴근
			}
		}

		List<String> list = new ArrayList<>();

		for (String name : m.keySet()) {
			if (m.get(name) == 1) {
				list.add(name);
			}
		}

		Collections.sort(list, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();
		for (String name : list) {
			sb.append(name).append("\n");
		}
		System.out.println(sb);
	}

}
