package July;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 2, 3 };
		for (int n : topKFrequent(arr, 2)) {
			System.out.println(n);
		}
	}

	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int number : nums) {
			hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
		}

		Queue<Integer> queue = new PriorityQueue<>((a, b) -> hashMap.get(a) - hashMap.get(b));

		for (int n : hashMap.keySet()) {
			queue.add(n);
			if (queue.size() > k) {
				queue.poll();
			}
		}

		int[] result = new int[k];
		int i = 0;
		for (int n : queue) {
			result[i++] = n;
		}

		return result;
	}

}
