package August;

public class isPalindrome {

	public static void main(String[] args) {
		System.out.println(isValid("A man, a plan, a canal: Panama"));
	}

	private static boolean isValid(String s) {
		int start = 0;
		int end = s.length() - 1;
		s = s.toLowerCase();
		while (start < end) {
			if (Character.isLetterOrDigit(s.charAt(start))) {
				if (Character.isLetterOrDigit(s.charAt(end))) {
					System.out.println(s.charAt(start) + " and " + s.charAt(end));
					if (s.charAt(start) != s.charAt(end)) {
						return false;
					} else {
						start++;
						end--;
					}
				} else {
					end--;
				}
			} else {
				start++;
			}
		}

		return true;
	}

}
