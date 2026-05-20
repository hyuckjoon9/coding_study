public class Solution {
	static boolean[] visited;
	public int solution(int n, int[][] computers) {
		visited = new boolean[n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, n, computers);
				answer++;
			}

		}

		return answer;
	}

	public void dfs(int v, int n, int[][] computers) {
		visited[v] = true;

		for (int i = 0; i < n; i++) {
			if (computers[v][i] == 1 && !visited[i]) {
				dfs(i, n, computers);
			}
		}
	}
}
