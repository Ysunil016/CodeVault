package _30Days.WeekFour;

import java.util.HashMap;

public class SubarrayEqualSumK {

	public static void main(String[] args) {
		int[] arr = { -1, -1, 1 };
		System.out.println(getCountO(arr, 0));
	}

	static int getCount(int[] arr, int key) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == key)
					count++;
			}
		}
		return count;
	}

	static int getCountO(int[] nums, int key) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int count = 0;
		int prefixSum = 0;
		if (nums.length == 1) {
			if (nums[0] == key)
				return 1;
			else
				return 0;
		}

		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (prefixSum == key)
				count++;

			if (hash.containsKey(prefixSum - key))
				count += hash.get(prefixSum - key);

			if (hash.containsKey(prefixSum))
				hash.put(prefixSum, hash.get(prefixSum) + 1);
			else
				hash.put(prefixSum, 1);

		}
		return count;
	}

}
