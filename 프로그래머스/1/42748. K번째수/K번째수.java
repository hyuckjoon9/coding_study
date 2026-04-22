import java.util.Arrays;

class Solution {
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		StringBuilder sb = new StringBuilder();

		int i = 0, j = 0, k = 0;
		for (int t = 0; t < commands.length; t++) {
			i = commands[t][0] - 1;
			j = commands[t][1];
			k = commands[t][2];

			int[] tempArr = Arrays.copyOfRange(array, i, j);

			Arrays.sort(tempArr);
			answer[t] = tempArr[k - 1];

		}

		return answer;
	}
}