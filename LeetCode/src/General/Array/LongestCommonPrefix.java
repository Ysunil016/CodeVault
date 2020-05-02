package General.Array;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] arr = { "flower", "flow", "fl" };
		System.out.println(getCommonPrefix(arr));
	}

	static String getCommonPrefix(String[] strArr) {
		StringBuilder str = new StringBuilder();
		boolean isValid = true;
		if (strArr.length == 0)
			return "";
		for (int i = 0; i < strArr[0].length(); i++) {
			for (int j = 1; j < strArr.length; j++) {
				if (i < strArr[j].length()) {
					if (strArr[0].charAt(i) == strArr[j].charAt(i)) {
						isValid &= true;
					} else {
						isValid &= false;
						break;
					}
				} else {
					isValid &= false;
					break;
				}
			}
			if (isValid)
				str.append(strArr[0].charAt(i));
			else
				return new String(str);
		}
		return new String(str);
	}

}
