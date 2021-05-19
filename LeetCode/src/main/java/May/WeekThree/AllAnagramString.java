package May.WeekThree;

import java.util.ArrayList;
import java.util.List;

public class AllAnagramString {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> ll = findAnagrams(s, p);
		for (int x : ll) {
			System.out.println(x);
		}
	}

	static List<Integer> findAnagrams(String s, String p) {
		int[] Primary = new int[26];
		for (int i = 0; i < p.length(); i++) {
			Primary[p.charAt(i) - 'a']++;
		}
		List<Integer> result = new ArrayList<Integer>();
		int[] secondary = new int[26];
		for (int i = 0; i < s.length(); i++) {
			secondary[s.charAt(i) - 'a']++;
			if (i >= p.length()) {
				secondary[s.charAt(i - p.length()) - 'a']--;
			}
			if (compare(Primary, secondary)) {
				result.add(i - p.length() + 1);
			}
		}
		return result;
	}

	static boolean compare(int[] x, int[] y) {
		for (int i = 0; i < 26; i++) {
			if (x[i] != y[i])
				return false;
		}
		return true;
	}

}
