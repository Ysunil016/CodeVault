package String;

import java.util.HashMap;

public class LongestDistinctSubString {

	public static void main(String[] args) {
		System.out.println(getLongestSubString("aewergrththy"));
	}

	static int getLongestSubString(String in) {
		if (in == null)
			return -1;
		int maxLen = 0;
		int tempLen = 0;
		char[] inChar = in.toCharArray();

		HashMap<Character, Boolean> store = new HashMap<Character, Boolean>();
		for (int i = 0; i < inChar.length; i++) {
			if (!isAlreadyPresent(store, in.charAt(i))) {
				tempLen++;
			} else {
				// Just for the Sake of Traversing Each and After Elements
				i -= tempLen;
				tempLen = 0;
				store.clear();
			}
			if (tempLen > maxLen)
				maxLen = tempLen;
		}
		return maxLen;
	}

	static boolean isAlreadyPresent(HashMap<Character, Boolean> store, char in) {
		if (!store.containsKey(in)) {
			store.put(in, true);
			return false;
		} else {
			return true;
		}
	}
}
