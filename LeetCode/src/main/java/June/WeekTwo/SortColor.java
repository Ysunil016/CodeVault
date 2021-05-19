package June.WeekTwo;

public class SortColor {

	public static void main(String[] args) {
		int[] colors = { 2, 1, 0, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 2, 2, 2, 2, 1, 2, 0 };
		sortColors(colors);
		for (int x : colors) {
			System.out.print(x + " ");
		}
	}

	public static void sortColors(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		int index = 0;
		while (index <= end && start < end) {
			if (nums[index] == 0) {
				nums[index] = nums[start];
				nums[start] = 0;
				start++;
				index++;
			} else if (nums[index] == 2) {
				nums[index] = nums[end];
				nums[end] = 2;
				end--;
			} else
				index++;
		}

	}

}
