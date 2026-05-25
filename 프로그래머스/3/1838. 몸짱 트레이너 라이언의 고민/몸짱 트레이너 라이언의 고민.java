import java.util.ArrayList;
import java.util.List;

class Solution {
	int n;
	int m;
	int[][] timetable;
	int maxPeople;

	public int solution(int n, int m, int[][] timetable) {
		this.n = n;
		this.m = m;
		this.timetable = timetable;
		int answer = 0;
		maxPeople = 0;
		for (int i = 600; i <= 1320; i++) {
			int people = 0;
			for (int[] times : timetable) {
				if (times[0] <= i && i <= times[1]) {
					people++;
				}
			}

			maxPeople = Math.max(maxPeople, people);
		}

		if (maxPeople == 1)
			return 0;

		for (int dist = 2 * (n - 1); dist >= 0; dist--) {
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (canPlace(r, c, dist))
						return dist;
				}
			}
		}
		return answer;
	}

	public boolean canPlace(int r, int c, int dist) {
		List<int[]> nodes = new ArrayList<>();
		nodes.add(new int[] { r, c });

		for (int nextR = 0; nextR < n; nextR++) {
			for (int nextC = 0; nextC < n; nextC++) {
				int d = 0;
				boolean flag = true;
				for (int[] node : nodes) {
					d = Math.abs(nextR - node[0]) + Math.abs(nextC - node[1]);
					if (dist > d) {
						flag = false;
						break;
					}
				}
				if (flag)
					nodes.add(new int[] { nextR, nextC });
			}
		}

		if (nodes.size() >= maxPeople)
			return true;
		else
			return false;

	}
}