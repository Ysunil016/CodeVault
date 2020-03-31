package Ignite;

public class ReverseWordInAString {

	public static void main(String[] args) {
		String str = "i.like.this.program.very.much";
		reverseWordsInAString(str);
	}

	static String reverseWordsInAString(String str) {
		// Splitting Words Based on \\. Separator
		String[] arr = str.split("\\.");
		// Switching Words InPlace
		int i = 0;
		for (i = 0; i < arr.length / 2; i++) {
			String placeHolder = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = arr[i];
			arr[i] = placeHolder;
		}
		StringBuffer strBuffer = new StringBuffer();
		for (i = 0; i < arr.length - 1; i++) {
			strBuffer.append(arr[i]).append(".");
		}
		strBuffer.append(arr[i]);
		System.out.println(strBuffer);
		return new String(strBuffer);
	}

}
