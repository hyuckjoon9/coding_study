import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] numbers;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new int[] { start, end });
		}

		Collections.sort(list, (a, b) -> {
			if (a[1] == b[1])
				return a[0] - b[0];
			return a[1] - b[1];
		});


		int count = 0;
		int lastEnd = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[0] >= lastEnd) {
				count++;
				lastEnd = list.get(i)[1];
			}
		}

		System.out.println(count);

	}

}