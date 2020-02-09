package Array;

public class RemoveOccurance {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 2, 3 };
		System.out.println(getRemoved(nums, 3));
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	static int getRemoved(int[] nums, int val) {
		int result = 0;
		int pointer = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == val && i < nums.length - 1) {
				result++;
				nums[pointer + 1] = nums[i + 1];
			} else {
				pointer++;
			}
		}
		return result;
	}

}
