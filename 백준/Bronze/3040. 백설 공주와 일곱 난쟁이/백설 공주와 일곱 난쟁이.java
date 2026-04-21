import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int r;
	static int[] numbers; 
	static int[] input; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		input = new int[9];
		n = 9;
		r = 7;
		numbers = new int[7];

		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		combi(0, 0);

		StringBuilder sb = new StringBuilder();

	}

	public static void combi(int depth, int start) {
		if (depth == r) {
			int sum = 0;
			for (int v : numbers) {
				sum += v;
			}

			if (sum == 100) {
				for (int v : numbers) {
					System.out.println(v);
				}
			}
			return;
		}

		for (int i = start; i < n; i++) {
			numbers[depth] = input[i];
			combi(depth + 1, i + 1);
		}
	}

}