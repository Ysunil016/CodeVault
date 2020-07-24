package _60Days.Bits;

public class NthMagicNumber {

	public static void main(String[] args) {
		System.out.println(getNthNumber(5));
	}

	static int getNthNumber(int n) {
		int result = 0;
		int i = 1;
		while (n != 0) {
			if ((n & 1) != 0) {
				result += Math.pow(5, i);
			}
			i++;
			n = n >> 1;
		}
		return result;
	}

}
