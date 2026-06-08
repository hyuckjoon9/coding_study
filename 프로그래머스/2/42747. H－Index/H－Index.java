import java.util.Arrays;

class Solution {
	public int solution(int[] citations) {
		int answer = 0;

		int len = citations.length;
		if (len == 1)
			return 1;

		Arrays.sort(citations);

		int[] reverse = new int[len];
		for (int i = 0; i < len; i++) {
			reverse[i] = citations[len - i - 1];
		}

        // 0 1 2 3 
        // 6 5 4 1 0
		for (int i = 0; i < len; i++) {
			if (i + 1 > reverse[i])
				return i;
			answer = i + 1;
		}
		return answer;
	}
}