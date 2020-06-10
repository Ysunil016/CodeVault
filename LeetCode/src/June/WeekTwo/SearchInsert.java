package June.WeekTwo;

public class SearchInsert {

	public static void main(String[] args) {
		int[] arr = { 1,3,5,6 };
		System.out.println(searchInsert(arr, 0));
	}

	public static int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		if (target < nums[0]) {
			return 0;
		}
		if (target > nums[nums.length - 1]) {
			return nums.length;
		}

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return low;
	}

}
