import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {

		int time = 0;
		Deque<Integer> waiting = new ArrayDeque<>();
		Deque<Integer> moving = new ArrayDeque<>();
		int movingWeight = 0;

		for (int i = 0; i < truck_weights.length; i++) {
			waiting.addLast(truck_weights[i]);

		}

		for (int i = 0; i < bridge_length; i++) {
			moving.addLast(0);
		}

		while (!moving.isEmpty()) {
			movingWeight -= moving.removeFirst();

			if (!waiting.isEmpty()) {
				if (waiting.peekFirst() + movingWeight <= weight) {
					moving.addLast(waiting.removeFirst());
				} else {
					moving.addLast(0);
				}
			}

			if (!moving.isEmpty()) {
				movingWeight += moving.peekLast();
			}

			time++;
		}

		return time;
	}
}