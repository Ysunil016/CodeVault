package May.WeekTwo;

public class SingleElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 3 };
		System.out.println(singleNonDuplicate(arr));
	}

	public static int singleNonDuplicate(int[] nums) {
		return keepTrack(nums, 0, nums.length - 1);
	}

	static int keepTrack(int[] nums, int start, int end) {
		if (start > end)
			return 0;

		int mid = start + (end - start) / 2;

		if (mid == 0) {
			return nums[mid];
		}
		if (mid == nums.length - 1) {
			return nums[mid];
		}

		if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
			return nums[mid];

		if (nums[mid] != nums[mid - 1]) {
			if (mid % 2 == 0) {
				return keepTrack(nums, mid + 1, end);
			} else {
				return keepTrack(nums, start, mid);
			}

		} else {
			if (mid % 2 == 0) {
				return keepTrack(nums, start, mid);
			} else {
				return keepTrack(nums, mid + 1, end);

			}
		}

	}

}
