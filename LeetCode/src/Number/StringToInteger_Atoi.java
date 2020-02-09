package Number;

public class StringToInteger_Atoi {

	public static void main(String[] args) {
		System.out.println(myAtoi("   -42"));
	}

	static int myAtoi(String input) {
		char[] array = input.toCharArray();
		StringBuilder str = new StringBuilder();
		int i = 0;
		if (array[0] == '-') {
			str.append('-');
			i++;
		}
		for (; i < array.length; i++) {
			if (Character.getNumericValue(array[i]) >= 0 && Character.getNumericValue(array[i]) <= 9) {
				str.append(array[i]);
			} else {
				break;
			}
		}
		try {
			int result = Integer.valueOf(new String(str));
			return result;
		} catch (Exception e) {
			return 0;
		}
	}

}
