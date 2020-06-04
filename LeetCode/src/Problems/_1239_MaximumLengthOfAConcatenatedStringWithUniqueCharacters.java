package Problems;

import java.util.ArrayList;
import java.util.List;

public class _1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

	public static void main(String[] args) {
		Solution sol = new Solution();
		List<String> arr = new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("cha");
				add("r");
				add("act");
				add("ers");
			}
		};
		System.out.println(sol.maxLength(arr));
	}

}

class Solution {
	public int maxLength(List<String> arr) {
		int[] result = new int[1]; // Result through Recursion
		findUnique(arr, 0, "", result);
		return result[0];
	}

	private void findUnique(List<String> arr, int index, String current, int[] result) {
		if (index == arr.size() && charCount(current) > result[0]) {
			result[0] = current.length();
		}
		if (index == arr.size()) {
			return;
		}
		findUnique(arr, index + 1, current, result);
		findUnique(arr, index + 1, current + arr.get(index), result);

	}

	private int charCount(String str) {
		int[] counts = new int[26];
		for (char c : str.toCharArray()) {
			if (counts[c - 'a']++ > 0) {
				return -1;
			}
		}
		return str.length();
	}

}