package September;

public class LastWordCount {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Sunil Here Again"));
	}

	public static int lengthOfLastWord(String s) {
		s = s.trim();
		if (s == null || s.length() == 0)
			return 0;
		String[] splitString = s.split(" ");
		return (splitString.length > 1) ? splitString[splitString.length - 1].length() : s.length();
	}

}
