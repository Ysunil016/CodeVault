package May.WeekThree;

public class StringPermutation {

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
	}

	public static boolean checkInclusion(String s1, String s2) {
		int[] prime = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			prime[s1.charAt(i) - 'a']++;
		}
		int[] second = new int[26];
		for (int i = 0; i < s2.length(); i++) {
			second[s2.charAt(i) - 'a']++;
			if (i >= s1.length()) {
				second[s2.charAt(i - s1.length()) - 'a']--;
			}
			if (compare(prime, second)) {
				return true;
			}
		}
		return false;
	}
	static boolean compare(int[] x, int[] y) {
		for (int i = 0; i < 26; i++) {
			if (x[i] != y[i])
				return false;
		}
		return true;
	}

}
