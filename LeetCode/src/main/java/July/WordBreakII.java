package July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreakII {

	public static void main(String[] args) {
		List<String> dict = new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa",
				"aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
		String r = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

		for (String x : wordBreakHelper(r, dict, new HashMap<>())) {
			System.out.println(x);
		}
	}

	// *********************************** MySolution
	// ************************************* //

	private static List<String> wordBreakHelper(String s, List<String> wordDict,
			HashMap<String, List<String>> memorize) {
		if (memorize.containsKey(s))
			return memorize.get(s);

		List<String> result = new ArrayList<String>();

		if (s.length() == 0) {
			result.add("");
			return result;
		}

		for (String word : wordDict) {
			if (s.startsWith(word)) {
				String sub = s.substring(word.length());
				List<String> subString = wordBreakHelper(sub, wordDict, memorize);

				for (String subStr : subString) {
					String spaceOptional = subStr.isEmpty() ? "" : " ";
					result.add(word + spaceOptional + subStr);
				}
			}
		}

		memorize.put(s, result);

		return result;
	}

	static List<String> finalOutput;
	static Deque<String> strBuilderRepetative;

	public static List<String> wordBreak2s(String s, List<String> wordDict) {
		finalOutput = new ArrayList<>();
		strBuilderRepetative = new LinkedList<>();

		HashSet<String> hashSet = new HashSet<>();
		for (String x : wordDict)
			hashSet.add(x);

		char[] sArray = s.toCharArray();
		word(hashSet, sArray, 0);

		return finalOutput;
	}

	static void word(HashSet<String> hashSet, char[] strArray, int index) {
		if (index >= strArray.length) {
			String res = "";
			Queue<String> sQueue = new LinkedList<>(strBuilderRepetative);
			while (!sQueue.isEmpty()) {
				res += sQueue.remove() + " ";
			}
			finalOutput.add(res.trim());
			return;
		}

		StringBuilder strBuilder = new StringBuilder();
		for (int i = index; i < strArray.length; i++) {
			strBuilder.append(strArray[i]);

			System.out.println(strBuilder);
			String xSearch = new String(strBuilder);

			if (hashSet.contains(xSearch)) {
				strBuilderRepetative.addLast(xSearch);
				word(hashSet, strArray, i + 1);
				strBuilderRepetative.removeLast();
			}
		}
	}

}
