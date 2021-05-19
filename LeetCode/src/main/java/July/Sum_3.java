package July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_3 {

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		for (List<Integer> x : threeSum(arr)) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}

		return res;
	}
}
