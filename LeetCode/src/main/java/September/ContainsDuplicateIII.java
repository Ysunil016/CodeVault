package September;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII {

	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k < 0 || t < 0) {
			return false;
		}

		TreeSet<Long> Set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			long currentNumber = (long) nums[i];

			long leftBoundary = (long) currentNumber - t;
			long rightBoundary = (long) currentNumber + t + 1;
			SortedSet<Long> sortedSet = Set.subSet(leftBoundary, rightBoundary);
			if (sortedSet.size() > 0) {
				return true;
			}
			Set.add(currentNumber);

			if (i >= k) {
				Set.remove((long) nums[i - k]);
			}

		}

		return false;
	}
}
