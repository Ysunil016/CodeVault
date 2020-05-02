package General.Array;

public class TwoSum {

	public static void main(String[] args) {

		int[] inputArray = { 2, 7, 11, 15 };
		twoSum(inputArray, 9);
	}

	static int[] twoSum(int[] nums, int target) {

		// Initialising for the Final Result
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
		System.out.println(result[0] + "and" + result[1]);
		return nums;
	}

}


//Leet Code Remark

//  Runtime: 50 ms, faster than 6.98% of Java online submissions for Two Sum.
//	Memory Usage: 37.3 MB, less than 98.95% of Java online submissions for Two Sum.
