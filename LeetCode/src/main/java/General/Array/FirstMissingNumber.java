package General.Array;

public class FirstMissingNumber {

	public static void main(String[] args) {
		int[] nums = {0, 2, 4, 6 };
		System.out.println(firstMissingPositive(nums));
	}

	static int firstMissingPositive(int[] nums) {
		int result = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		System.out.println("Min " + min + " and " + max);
		
		return result;
	}

}
