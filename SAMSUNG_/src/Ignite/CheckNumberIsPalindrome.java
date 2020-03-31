package Ignite;

public class CheckNumberIsPalindrome {

	public static void main(String[] args) {
		int Number = 2;
		System.out.println(isNumberPalindrome(Number));
	}

	static boolean isNumberPalindrome(int Number) {
		// Finding the Length of Number
		int tNum = Number;
		int numCount = 0;
		while (tNum != 0) {
			tNum = tNum / 10;
			numCount++;
		}

		// Iterating for Half of Found Lenght
		for (int i = 0; i < numCount / 2; i++) {

			// Checking if Most and Least Bit of Number is Same..
			if (Number % 10 != (int) (Number / (Math.pow(10, (numCount - 1)))))
				return false;

			numCount--;
			Number /= 10;
		}

		return true;
	}

}
