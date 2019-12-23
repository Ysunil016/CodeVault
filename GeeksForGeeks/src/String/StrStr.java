package String;

public class StrStr {

	public static void main(String[] args) {

		System.out.println(getFirstOccurance("abcabcabcd", "abcd"));

	}

	static int getFirstOccurance(String original, String sub) {
		if (sub.length() > original.length())
			return -1;

		for (int i = 0; i < original.length() - sub.length() + 1; i++) {
			String subS = original.subSequence(i, sub.length() + i).toString();
			if (sub.compareTo(subS) == 0)
				return i;
		}
		return -1;
	}

}
