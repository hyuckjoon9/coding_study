import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public static String solution(int[] numbers) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}

		Collections.sort(list, (a, b) -> {
			String ab = String.valueOf(a) + String.valueOf(b);
			String ba = String.valueOf(b) + String.valueOf(a);

			return ba.compareTo(ab);
		});

		StringBuilder sb = new StringBuilder();
		for (Integer v : list) {
			sb.append(v.intValue());
		}

		if (sb.toString().charAt(0) == '0') {
			return "0";
		}
		return sb.toString();
	}
}