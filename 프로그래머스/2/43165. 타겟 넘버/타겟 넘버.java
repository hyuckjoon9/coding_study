class Solution {
	static int count;
	public static int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);

		int answer = count;
		return answer;
	}

	public static void dfs(int[] numbers, int target, int i, int sum) {
		if (i > numbers.length)
			return;

		if (i == numbers.length) {
			if (sum == target) {
				count++;
			}
			return;
		}

		dfs(numbers, target, i + 1, sum + numbers[i]);
		dfs(numbers, target, i + 1, sum - numbers[i]);

	}
}