package Array;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };

		for (int i : nums)
			System.out.print(" " + i);
		System.out.println();

		rotateArray(nums, 7);
		System.out.println();
		for (int i : nums)
			System.out.print(" " + i);

	}

	static void rotateArray(int[] nums, int rounds) {
		int i = 0;
		for (i = 0; i < nums.length - rounds; i++) {
			int temp = nums[i];
			nums[i] = nums[i + rounds];
			nums[i + rounds] = temp;
		}

//		int temp = nums[i];
//		for (int j = i; j < nums.length - 1; j++) {
//			nums[j] = nums[j + 1];
//			nums[j + 1] = temp;
//		}

	}
}
