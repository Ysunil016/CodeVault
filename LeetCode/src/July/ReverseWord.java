package July;

public class ReverseWord {

	public static void main(String[] args) {
		System.out.println(reverseWords("a good   example"));
	}

	public static String reverseWords(String s) {
		if (s == null) {
			return new String();
		}
		s = s.trim();
		String[] list = s.split(" ");
		StringBuilder strBuilder = new StringBuilder();
		for (int i = list.length - 1; i > 0; i--) {
			if (list[i].length() != 0) {
				strBuilder.append(list[i].trim());
				strBuilder.append(" ");
			}
		}
		strBuilder.append(list[0]);
		return new String(strBuilder);
	}

}
