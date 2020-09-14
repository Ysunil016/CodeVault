package September;

import java.util.Arrays;

public class HouseRobber {

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 4, 3, 1, 4, 6, 3, 2 }));
	}

	public static int rob(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);
		return findTheRob(nums, 0, dp);
	}

	private static int findTheRob(int[] nums, int index, int[] dp) {
		if (index >= nums.length) {
			return 0;
		}

		if (dp[index] != -1)
			return dp[index];

		int result = Math.max(findTheRob(nums, index + 1, dp), nums[index] + findTheRob(nums, index + 2, dp));

		dp[index] = result;

		return result;
	}

}
