package General.Number;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}

	static int reverse(int x) {
		char ch[] = String.valueOf(x).toCharArray();
		int iterator = 0;
		StringBuilder result = new StringBuilder();
		if (ch[0] == '-') {
			result.append('-');
			iterator++;
		}
		for (int i = ch.length - 1; i >= iterator; i--) {
			result.append(ch[i]);
		}
		try {
			return Integer.parseInt(new String(result));
		} catch (Exception e) {
			return 0;
		}
	}

}
