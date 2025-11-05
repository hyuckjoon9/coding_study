import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			int result = 0;

			for (int i = 1; i <= 10; i++) {
				Boolean isSame = true;
				String pattern = str.substring(0, i);
				for (int j = 0; j < str.length(); j += i) {
					if (j + i > str.length())
						break;

					if (!pattern.equals(str.substring(j, j + i))) {
						isSame = false;
						break;
					}

				}
				if (isSame) {
					result = i;
					break;
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}
}
