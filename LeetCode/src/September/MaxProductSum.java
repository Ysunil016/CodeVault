package September;

public class MaxProductSum {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -4, 3 }));
	}

	public static int maxProduct(int[] nums) {
		int max = nums[0];
		for (int i = 1, currMax = nums[0], currMin = nums[0]; i < nums.length; i++) {
			if (nums[i] < 0) {
				int temp = currMax;
				currMax = currMin;
				currMin = temp;
			}
			currMax = Math.max(nums[i], currMax * nums[i]);
			currMin = Math.min(nums[i], currMin * nums[i]);
			max = Math.max(max, currMax);
		}

		return max;
	}

}
