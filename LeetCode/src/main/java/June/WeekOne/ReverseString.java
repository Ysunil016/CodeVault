package June.WeekOne;

public class ReverseString {

	public static void main(String[] args) {
		char[] arr = { 'h', 'e', 'l', 'l', 'o' };
		System.out.println(arr);
		reverseString(arr);
		System.out.println(arr);
	}

	public static void reverseString(char[] s) {
		int e = s.length;
		for (int i = 0; i < e / 2; i++) {
			char x = s[i];
			s[i] = s[e - 1 - i];
			s[e - 1 - i] = x;
		}
	}

}
