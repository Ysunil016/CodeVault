package General.Problems;

import java.util.HashMap;

public class longestSubStringWithoutRepetation {

	public static void main(String[] args) {

		System.out.println(lengthOfLongestSubstring("qwerty"));

	}

	public static int lengthOfLongestSubstring(String s) {
		int maxString = 0;
		int beginPointer = 0;

		// Storing String Info into HashMap
		HashMap<Character, Integer> storeMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			// Replanning Begin Pointer from Max of Old Pointer and Store
			if (storeMap.containsKey(s.charAt(i))) {
				beginPointer = Math.max(beginPointer, storeMap.get(s.charAt(i)) + 1);
			}
			// Updating charPos using Index
			storeMap.put(s.charAt(i), i);
			maxString = Math.max(maxString, i + 1 - beginPointer);
		}

		return maxString;
	}

}
