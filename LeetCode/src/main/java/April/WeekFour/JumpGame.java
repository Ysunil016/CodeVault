package April.WeekFour;

public class JumpGame {

	static boolean canJump = false;

	public static void main(String[] args) {
		int[] arr = { 8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7,
				6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7,
				0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5 };
		System.out.println(canJump2(arr, 0));
	}

	public boolean optimalSolution(int[] nums) {
		int rechability = 0;
		for (int i = 0; i < nums.length; i++) {
			if (rechability < i)
				return false;
			rechability = Math.max(rechability, i + nums[i]);
		}
		return true;
	}

	// 1 Test Case Fails
	public static boolean canJump2(int[] nums, int index) {
		if (index >= nums.length)
			return false;

		if (index == nums.length - 1)
			return true;

		if (nums[index] == 0)
			return false;

		for (int i = 1; i <= nums[index]; i++) {
			if (canJump == true)
				return true;
			canJump |= canJump2(nums, index + i);
		}
		return canJump;
	}

}
