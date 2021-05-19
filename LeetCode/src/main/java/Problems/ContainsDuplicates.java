package Problems;

import java.util.Arrays;

public class ContainsDuplicates {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(containsDuplicate(nums));
	}

	public static boolean containsDuplicate(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return false;
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				return true;
		}
		return false;
	}

}
