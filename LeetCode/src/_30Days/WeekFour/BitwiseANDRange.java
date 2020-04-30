package _30Days.WeekFour;

public class BitwiseANDRange {

	public static void main(String[] args) {
		// 0001
		// 0010
		System.out.println(getAnd(5, 7));
	}

	static int getAnd(int m, int n) {

		int counter = 0;

		// Checking for Common Bits in M and N
		while (m != n) {
			counter++;
			m = m >> 1;
			n = n >> 1;
		}
		// Found Common Bits as Counter, Now Shifting Left
		n = n << counter;

		return n;
	}

}
