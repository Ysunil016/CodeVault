package April.WeekOne;

public class MaxSubArrayy {

	public static void main(String[] args) {
		int[] arr = { 4, -1, 2, 1 };
		System.out.println(findMaxSubArray(arr));
	}

	static int findMaxSubArray(int[] arr) {
		int sum = 0;
		int result = Integer.MIN_VALUE;
		for (int num : arr) {
			sum += num;
			result = Math.max(sum, result);
			if (sum < 0)
				sum = 0;
		}
		return (result == Integer.MIN_VALUE) ? -1 : result;
	}

}
