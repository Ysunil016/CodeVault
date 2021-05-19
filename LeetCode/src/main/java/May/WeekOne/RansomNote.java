package May.WeekOne;

import java.util.LinkedList;

public class RansomNote {

	public static void main(String[] args) {
		System.out.println(canConstructO("abbbbb", "aabababb"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		LinkedList<Character> list = new LinkedList<Character>();

		// Using Ransom String as the Primary String to be Iterated
		char[] R = ransomNote.toCharArray();

		// Adding Magazine Characters to LinkedList, as It will be Easy to Remove
		// Element.
		for (char x : magazine.toCharArray()) {
			list.add(x);
		}

		// Iterating for Ransom String
		for (int i = 0; i < R.length; i++) {
			Character X = R[i];
			if (list.isEmpty())
				return false;
			// If Character of the String is Present in Magazine, then Remove it from
			// Magazine
			if (list.contains(X)) {
				list.remove(X);
			} else
				return false;
		}

		return true;
	}

	public static boolean canConstructO(String ransom, String magazine) {
		int[] pool = new int[26];
		for (char c : ransom.toCharArray())
			pool[c - 'a'] -= 1;
		for (char c : magazine.toCharArray())
			pool[c - 'a'] += 1;

		for (int i = 0; i < 26; i++)
			if (pool[i] < 0)
				return false;
		return true;
	}
}
