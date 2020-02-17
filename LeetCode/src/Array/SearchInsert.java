package Array;

public class SearchInsert {

	public static void main(String[] args) {
		int nums[] = { 2, 5 };
		System.out.println(searchInsert(nums, 6));
	}

	static int searchInsert(int[] nums, int target) {
		int finalV = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target > nums[i]) {
				finalV++;
			} else
				break;
		}
		return finalV;
	}

}
