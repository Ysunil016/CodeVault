package July;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		for (List<Integer> x : getSubset(arr)) {
			for (int t : x) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> getSubset(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		generateSubset(0, nums, new ArrayList<>(), res);
		return res;
	}

	private static void generateSubset(int index, int[] nums, List<Integer> cur, List<List<Integer>> subset) {
		subset.add(new ArrayList<>(cur));
		for (int i = index; i < nums.length; i++) {
			cur.add(nums[i]);
			generateSubset(i + 1, nums, cur, subset);
			cur.remove(cur.size() - 1);
		}

	}

}
