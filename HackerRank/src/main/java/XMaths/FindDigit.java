package XMaths;

public class FindDigit {

	public static void main(String[] args) {
		System.out.println(findDigits(255426));
	}

	static int findDigits(int n) {
		// Breaking the Number into Digits
		int resultCount = 0;
		int OriginalNumber = n;
		while (n != 0) {
			int digit = n % 10;
			if (digit != 0) {
				if (OriginalNumber % digit == 0) {
					resultCount++;
				}
			}
			n = n / 10;
		}
		return resultCount;
	}

}
