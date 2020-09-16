package Array;

public class Expedia {

	public static void main(String[] args) {
		System.out.println(countOptions(4, 2));
	}

	private static long count = 0;

	public static long countOptions(int people, int groups) {
		for (int i = 1; i <= people; i++) {
			int[] res = new int[groups];
			makeArray(res, 0, i, people, people, 0);
		}
		return count;
	}

	private static void makeArray(int[] nums, int index, int curPeople, int People, int tP, int CSum) {

		// At Last Index
		if (index == nums.length - 1) {
			nums[index] = People - curPeople + 1;

			CSum += People - curPeople + 1;

			if (CSum != tP)
				return;

			for (int x : nums) {
				System.out.print(x + " ");
			}
			System.out.println();

			if (index != 0) {
				if (nums[index - 1] > nums[index])
					return;
			}

			if (checkIfGroupValid(nums, tP)) {
				count++;
			}
			return;
		}

		nums[index] = curPeople;
		People -= curPeople;
		CSum += curPeople;
		// Useless Iterations - Restrictions

		if (index != 0 && nums[index] < nums[index - 1])
			return;

		if (index != 0) {
			if (nums[index - 1] > nums[index])
				return;
		}

		for (int i = 1; i <= People; i++) {
			makeArray(nums, index + 1, i, People, tP, CSum);
		}
	}

	private static boolean checkIfGroupValid(int[] nums, int tP) {
		int i = 0;
		int Count = 0;
		for (i = 0; i < nums.length - 1; i++) {
			Count += nums[i];
			if (nums[i] > nums[i + 1])
				return false;
		}
		Count += nums[i];
		if (Count != tP)
			return false;

		return true;
	}

}
