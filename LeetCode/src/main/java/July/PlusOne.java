package July;

public class PlusOne {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		for (int x : plusOne(arr)) {
			System.out.print(x + " ");
		}
	}

	private static int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + carry == 10) {
				digits[i] = 0;
			} else {
				digits[i] += carry;
				carry = 0;
				return digits;
			}
		}
		int[] nArray = new int[digits.length + 1];
		for (int i = digits.length - 1; i >= 0; i--) {
			nArray[i + 1] = digits[i];
		}
		nArray[0] = carry;

		return nArray;
	}

}
