public class Solution {
	public int[] solution(int brown, int yellow) {
		int[] answer = {};


		int yR = 0;
		int yC = 0;
		int bR = 0;
		int bC = 0;

		for (int i = 1; i <= Math.sqrt(yellow); i++) {
			if (yellow % i != 0) continue;
			yC = i;
			yR = yellow / yC;

			bR = yR + 2;
			bC = yC + 2;

			int brownArea = 2 * yR + 2 * yC + 4;
			if (brownArea == brown) return new int[] { bR, bC };
		}

		return answer;
	}
}