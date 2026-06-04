import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	List<String> path;
	String[][] tickets;
	String[] answer;
	boolean[] visited;
	boolean end;

	public String[] solution(String[][] tickets) {
		this.tickets = tickets;
		path = new ArrayList<>();
		visited = new boolean[tickets.length];

		Arrays.sort(tickets, (a, b) -> {
			if (a[0].equals(b[0])) {
				return a[1].compareTo(b[1]);
			}
			return a[0].compareTo(b[0]);
		});

		path.add("ICN");
		track("ICN", 0);

		return answer;
	}

	public void track(String start, int cnt) {
		if (cnt == tickets.length) {
			answer = path.toArray(new String[0]);
			end = true;
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (visited[i] || !start.equals(tickets[i][0]))
				continue;
			if (end)
				return;
			visited[i] = true;
			path.add(tickets[i][1]);

			track(tickets[i][1], cnt + 1);

			visited[i] = false;
			path.remove(path.size() - 1);
		}
	}
}