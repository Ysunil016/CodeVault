package June.WeekThree;

import java.util.HashSet;

public class DuplicateSubString {

	public static void main(String[] args) {
		System.out.println(longestDupSubstring("abcdab"));
	}

	public static String longestDupSubstring(String S) {
		int len = S.length();
		int[] nums = new int[len];

		for (int i = 0; i < len; i++)
			nums[i] = (int) S.charAt(i) - (int) 'a';

		int a = 26;
		long mod = (long) Math.pow(2, 32);
		int l = 1;
		int r = len;
		int m;
		while (l < r) {
			m = l + (r - l) / 2;
			if (search(m, a, mod, len, nums) != -1) {
				l = m + 1;
			} else {
				r = m;
			}

		}

		int StartingPoint = search(l - 1, a, mod, len, nums);

		return (StartingPoint != -1) ? S.substring(StartingPoint, StartingPoint + l - 1) : "";
	}

	private static int search(int L, int a, long mod, int n, int[] nums) {

		long h = 0;

		for (int i = 0; i < L; i++) {
			h = (h * a + nums[i]) % mod;
		}

		HashSet<Long> hS = new HashSet<Long>();
		hS.add(h);

		long aL = 1;

		for (int i = 1; i <= L; i++) {
			aL = (aL * a) % mod;
		}

		for (int start = 1; start < n - L + 1; start++) {
			h = (h * a - nums[start - 1] * aL % mod + mod) % mod;
			h = (h + nums[start + L - 1]) % mod;
			if (hS.contains(h))
				return start;
			hS.add(h);
		}

		return -1;
	}

}
