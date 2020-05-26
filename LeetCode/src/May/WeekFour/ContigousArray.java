package May.WeekFour;

import java.util.HashMap;

public class ContigousArray {

	public static void main(String[] args) {
		int[] arr = { 0, 1 };
		System.out.println(findMaxLength(arr));
	}

	public static int findMaxLength(int[] nums) {
		int fResult = 0;
		int counter = 0;
		HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				counter -= 1;
			} else {
				counter += 1;
			}
			if (counter == 0) {
				fResult = i + 1;
			}
			if (store.containsKey(counter)) {
				fResult = Math.max(fResult, i - store.get(counter));
			} else {
				store.put(counter, i);
			}
		}
		return fResult;
	}

}
