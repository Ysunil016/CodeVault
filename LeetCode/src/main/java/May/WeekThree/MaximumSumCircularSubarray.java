package May.WeekThree;

public class MaximumSumCircularSubarray {

	public static void main(String[] args) {
		int[] arr = { 5, -3, 5 };
		System.out.println(getCircularMaxVal(arr));
	}

	static int getCircularMaxVal(int[] nums) {
		int kadane_one = kadane(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			nums[i] *= -1;
		}

		System.out.println(kadane_one);
		System.out.println(sum);
		
		System.out.println(kadane_one);
		int kadane_two = kadane(nums) + sum;
		if (kadane_two > kadane_one && kadane_two != 0) {
			return kadane_two;
		} else {
			return kadane_one;
		}
	}

	static int kadane(int[] arr) {
		int len = arr.length;
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;

		for (int i = 0; i < len; i++) {
			max_ending_here = max_ending_here + arr[i];
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}

}
