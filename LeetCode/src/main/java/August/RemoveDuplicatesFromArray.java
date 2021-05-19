package August;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromArray {

	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] { 1, 2, 3, 1, 3, 6, 4 }));
	}

	public static List<Integer> findDuplicates(int[] nums) {
		int[] fra = new int[nums.length + 1];
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int n : nums)
			fra[n]++;
		for (int i = 0; i < fra.length; i++) {
			if (fra[i] == 2)
				result.add(i);
		}
		return result;
	}

}
