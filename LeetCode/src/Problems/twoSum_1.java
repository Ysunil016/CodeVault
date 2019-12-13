package Problems;

public class twoSum_1 {

	public static void main(String[] args) {
		int[] inputArray = { 2, 7, 11, 15 };
		int target = 0;
		twoSum(inputArray, target);
	}

	public static int[] twoSum(int[] nums, int target) {

		int[] result = { 0, 0 };

		// To Reduce Complexity Lets Fetch length of Num;
		int arLen = nums.length;

		// Finding all Combinations
		for (int i = 0; i < arLen; i++) {
			for (int j = i; j < arLen; j++) {
				if (i != j) {
					boolean isSumEqual = (nums[i] + nums[j] == target) ? true : false;
					if (isSumEqual) {
						result[0] = i;
						result[1] = j;
					}
				}
			}
		}
		return result;
	}
}
