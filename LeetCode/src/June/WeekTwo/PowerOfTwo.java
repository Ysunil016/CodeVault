package June.WeekTwo;

public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(64));
	}

	public static boolean isPowerOfTwo(int n) {
		if (n < 0) {
			return false;
		}
		int counter = 0;
		while (n != 0) {
			if (n % 2 != 0)
				counter++;
			n = n >> 1;
		}
		return (counter == 1) ? true : false;
	}

}
