package String;

public class RemoveAdjDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDups("mississipie"));
	}

	static String removeDups(String input) {
		if (isStringUnique(input)) {
			return input;
		}

		char[] in = input.toCharArray();
		StringBuilder result = new StringBuilder();
		boolean prev = false;
		for (int i = 0; i < in.length - 1; i++) {
			if (in[i] != in[i + 1]) {
				if (!prev)
					result.append(in[i]);
				prev = false;
			} else {
				prev = true;
			}
		}
		if (!prev)
			result.append(in[in.length - 1]);

		return removeDups(new String(result));
	}

	static boolean isStringUnique(String in) {
		char[] inp = in.toCharArray();
		boolean isUnique = true;
		for (int i = 0; i < inp.length - 1; i++) {
			if (inp[i] == inp[i + 1])
				return false;
		}
		return isUnique;
	}

}
