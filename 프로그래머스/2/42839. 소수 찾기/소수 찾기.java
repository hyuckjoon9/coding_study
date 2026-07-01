import java.util.HashSet;
import java.util.Set;

class Solution {
	Set<Integer> nums;
	int len;

	public int solution(String numbers) {
		int answer = 0;

		len = numbers.length();

		boolean[] visited = new boolean[len];
		nums = new HashSet<>();

		permutation(numbers, visited, "");

		for (Integer n : nums) {
			
			if (isSosu(n.intValue())) {
				
				System.out.println();
				answer++;
			}
		}

		return answer;
	}

	public void permutation(String numbers, boolean[] visited, String num) {
		if (!num.isEmpty()) nums.add(Integer.parseInt(num));

		for (int i = 0; i < len; i++) {
			if (visited[i]) continue;
			visited[i] = true;

			permutation(numbers, visited, num + numbers.charAt(i));

			visited[i] = false;
		}
	}

	public boolean isSosu(int num) {
		if (num == 0 || num == 1) return false;
	
		int cnt = 0;

		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) cnt++;
		}

		return cnt == 1 ? true : false;
	}
}