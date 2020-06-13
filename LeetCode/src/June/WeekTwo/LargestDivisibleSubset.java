package June.WeekTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 8 };
		List<Integer> res = largestDivisibleSubset(arr);
		for (int x : res) {
			System.out.print(x + " ");
		}
	}

	public static List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums.length == 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> res = new ArrayList<Integer>();
		Arrays.sort(nums);

		int prev[] = new int[nums.length];
		Arrays.fill(prev, -1);
		int divCount[] = new int[nums.length];
		Arrays.fill(divCount, 1);

		int MaxCOunt = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {

				if (nums[i] % nums[j] == 0 && divCount[i] < divCount[j] + 1) {
					prev[i] = j;
					divCount[i] = divCount[j] + 1;
				}
			}
			if (divCount[i] > divCount[MaxCOunt])
				MaxCOunt = i;
		}

		int k = MaxCOunt;
		while (k >= 0) {
			res.add(nums[k]);
			k = prev[k];
		}
		return res;
	}
}
