package April.WeekTwo;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		int[] arr = { 2, 2 };
		System.out.println(getStoned(arr));

	}

	static int getStoned(int[] arr) {
		// Priority Queue is an Implementation of Min Heap, we will use -ve for Making it Max Heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
		for (int x : arr) {
			maxHeap.add(-x);
		}

		while (maxHeap.size() > 1) {
			int One = -maxHeap.remove();
			int Two = -maxHeap.remove();
			int diff = Math.abs(Two - One);
			if (diff != 0) {
				maxHeap.add(-diff);
			}
		}

		if (maxHeap.size() == 0)
			return 0;

		return -maxHeap.remove();
	}

}
