package String;

public class LongestPalindromeInString {

	public static void main(String[] args) {
		String in = "aaaabbaa";
		String result = getMaxPalindrome(in);
		System.out.println(result);
	}

	static String getMaxPalindrome(String in) {
		int len = in.length();
		String max = "";
		for (int i = 0; i < len; i++) {
			String mem = "";
			for (int j = i; j < len; j++) {
				mem += in.charAt(j);
				if (isPalindrome(mem)) {
					if (mem.length() > max.length())
						max = mem;
				}
			}
		}
		return max;
	}

	static boolean isPalindrome(String in) {
		char[] ar = in.toCharArray();
		int len = ar.length;
		for (int i = 0; i < len / 2; i++) {
			if (ar[i] != ar[len - 1 - i]) {
				return false;
			}
		}
		return true;
	}

}
