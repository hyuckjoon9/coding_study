import java.util.Arrays;

class Solution {
	public static int solution(int n, int[] lost, int[] reserve) {
		Arrays.sort(lost);
		Arrays.sort(reserve);

		boolean[] extraCloth = new boolean[n + 2];
		boolean[] lostCloth = new boolean[n + 2];

		for (int i = 0; i < reserve.length; i++) {
			extraCloth[reserve[i]] = true;
		}
		for (int i = 0; i < lost.length; i++) {
			lostCloth[lost[i]] = true;
		}

		int answer = n - lost.length;
		for (int i = 0; i < lost.length; i++) {
			if (lostCloth[lost[i]] && extraCloth[lost[i]]) {
				extraCloth[lost[i]] = false;
				lostCloth[lost[i]] = false;
				answer++;
			}
		}

		for (int i = 0; i < lost.length; i++) {
			if (lostCloth[lost[i]] && extraCloth[lost[i] - 1]) {
				extraCloth[lost[i] - 1] = false;
				answer++;
			} else if (lostCloth[lost[i]] && extraCloth[lost[i] + 1]) {
				extraCloth[lost[i] + 1] = false;
				answer++;
			}
		}

		return answer;
	}
}