import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {



		Deque<Integer> onBridge = new ArrayDeque<>();

		for (int i = 0; i < bridge_length; i++) {
			onBridge.addLast(0);
		}

		int firstTruck = truck_weights[0];

		onBridge.removeFirst();
		onBridge.addLast(firstTruck);

		int time = 1;
		int truckIdx = 1;
		int bridgeTruckWeight = firstTruck;
		int bridgeTruckCnt = 1;

		while (!onBridge.isEmpty()) {
			if (truckIdx == truck_weights.length) break;

			if (onBridge.size() == bridge_length) {
				if (onBridge.peekFirst() != 0) {
					int outTruck = onBridge.removeFirst();
					bridgeTruckWeight -= outTruck;
					bridgeTruckCnt--;

				} else {
					onBridge.removeFirst();
				}
			}

			int nextTruck = truck_weights[truckIdx];

			if (bridgeTruckWeight + nextTruck <= weight) {
				if (bridgeTruckCnt + 1 <= bridge_length) {
					onBridge.addLast(nextTruck);
					bridgeTruckWeight += nextTruck;
					bridgeTruckCnt++;
					truckIdx++;
				}
			} else {
				onBridge.addLast(0);
			}

			time++;

		}

		while (bridgeTruckCnt != 0) {
			if (onBridge.peekFirst() != 0) {
				int outTruck = onBridge.removeFirst();
				bridgeTruckWeight -= outTruck;
				bridgeTruckCnt--;

			} else {
				onBridge.removeFirst();
			}
			time++;
		}

		return time;
	}
}