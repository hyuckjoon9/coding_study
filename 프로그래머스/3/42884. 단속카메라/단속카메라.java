import java.util.Arrays;

class Solution {
	public int solution(int[][] routes) {
		Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

		int camera = routes[0][1];
		int cameraCnt = 1;

		for (int i = 0; i < routes.length; i++) {
			if (routes[i][0] <= camera && camera <= routes[i][1])
				continue;
			camera = routes[i][1];
			cameraCnt++;
		}

		return cameraCnt;
	}
}