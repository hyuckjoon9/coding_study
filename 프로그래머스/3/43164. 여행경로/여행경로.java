import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	boolean[] visited;
	List<String> result;
	String[][] tickets;
	int count;
	String[] answer;
	boolean found;

	public String[] solution(String[][] tickets) {
		this.tickets = tickets;
		count = 0;

		Arrays.sort(tickets, (a, b) -> {
			if (a[0].equals(b[0])) {
				return a[1].compareTo(b[1]);
			}
			return a[0].compareTo(b[0]);
		});

		visited = new boolean[tickets.length];
		result = new ArrayList<>();

		result.add("ICN");
		back("ICN", 0);

		for (String s : answer) {
			System.out.print(s + " ");
		}
		return answer;
	}

	public void back(String cur, int count) {
		if (found)
			return;

		if (count == tickets.length) {
			answer = result.toArray(new String[0]);
			found = true;
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (visited[i])
				continue;
			if (!tickets[i][0].equals(cur))
				continue;

			visited[i] = true;
			result.add(tickets[i][1]);

			back(tickets[i][1], count + 1);

			visited[i] = false;
			result.remove(result.size() - 1);
		}
	}
}