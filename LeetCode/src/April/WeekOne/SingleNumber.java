package April.WeekOne;

import java.util.HashSet;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inte = { 4, 1, 2, 1, 2 };
		System.out.println(singleNumberBits(inte));

		int val = 4 ^ 0;
		System.out.println(val);

	}

	// Bits Manipulation
	public static int singleNumberBits(int[] nums) {
		int x = 0;
		for (int num : nums)
			x ^= num;
		return x;
	}

	// Using HashSet -- Additional Space Complexity
	public static int singleNumber(int[] nums) {
		HashSet<Integer> hash = new HashSet<Integer>();
		for (int num : nums) {
			if (hash.contains(num)) {
				hash.remove(num);
			} else
				hash.add(num);
		}
		return hash.iterator().next();
	}
}
