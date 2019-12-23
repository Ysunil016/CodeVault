package String;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Anagram {

	public static void main(String[] args) {
		String inOne = "geeksforgeeks";
		String inTwo = "forgeeksgeeks";
		System.out.println((isAnagram2(inOne, inTwo)) ? "YES" : "NO");
	}

	static boolean isAnagram(String inOne, String inTwo) {
		TreeMap<Character, Integer> charFreqOne = new TreeMap<Character, Integer>();
		TreeMap<Character, Integer> charFreqTwo = new TreeMap<Character, Integer>();

		for (int i = 0; i < inOne.length(); i++) {
			char currentChar = inOne.charAt(i);
			if (!charFreqOne.containsKey(currentChar)) {
				charFreqOne.put(currentChar, 1);
			} else {
				int freq = charFreqOne.get(currentChar);
				charFreqOne.put(currentChar, ++freq);
			}
		}
		for (int i = 0; i < inTwo.length(); i++) {
			char currentChar = inTwo.charAt(i);
			if (!charFreqTwo.containsKey(currentChar)) {
				charFreqTwo.put(currentChar, 1);
			} else {
				int freq = charFreqTwo.get(currentChar);
				charFreqTwo.put(currentChar, ++freq);
			}
		}

		for (Map.Entry<Character, Integer> elem : charFreqOne.entrySet()) {
			char temp = elem.getKey();
			if (!charFreqOne.get(temp).equals(charFreqTwo.get(temp))) {
				return false;
			}
		}
		return true;
	}

	static boolean isAnagram2(String inOne, String inTwo) {
		if (inOne.length() != inTwo.length())
			return false;

		char[] ar1 = inOne.toCharArray();
		char[] ar2 = inTwo.toCharArray();
		Arrays.sort(ar1);
		Arrays.sort(ar2);

		return Arrays.equals(ar1, ar2);
	}

}
