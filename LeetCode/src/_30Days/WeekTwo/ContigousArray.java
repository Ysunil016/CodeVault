package _30Days.WeekTwo;

import java.util.HashMap;

public class ContigousArray {

	public static void main(String[] args) {
		int[] nums = { 0, 1 };
		System.out.println(findMaxLength(nums));
	}

	public static int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> hashStore = new HashMap<Integer, Integer>();
		int count = 0;
		int maxEqual = 0;
		for (int J = 0; J < nums.length; J++) {
			if (nums[J] == 0)
				count--;
			if (nums[J] == 1)
				count++;

			if (count == 0)
				maxEqual = J + 1;

			if (hashStore.containsKey(count)) {
				maxEqual = Math.max(maxEqual, J - hashStore.get(count));
			} else
				hashStore.put(count, J);

		}
		return maxEqual;
	}

}
