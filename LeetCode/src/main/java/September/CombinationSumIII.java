package September;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {

	public static void main(String[] args) {
		System.out.println(combinationSum3(3, 8));
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> resultList = new ArrayList<>();
		backTrack(1, n, k, new LinkedList<Integer>(), resultList);
		return resultList;
	}

	private static void backTrack(int start, int end, int size, LinkedList<Integer> list, List<List<Integer>> result) {
		if (end == 0 && list.size() == size) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i <= 9; i++) {
			list.add(i);
			backTrack(i + 1, end - i, size, list, result);
			list.removeLast();
		}
	}

}
