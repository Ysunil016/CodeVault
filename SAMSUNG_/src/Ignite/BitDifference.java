package Ignite;

public class BitDifference {

	public static void main(String[] args) {

		int A = 180;
		int B = 106;
		getBitDifference(A, B);
	}

	static void getBitDifference(int A, int B) {
		// Bit Difference in A and B is Casually Can be Done by Making XOR of A and B
		// 1 0 -> 1
		// 0 1 -> 1
		int X = A ^ B;

		System.out.println("Bits Required to Change in A -> B " + bitSet(X));
	}

	static int bitSet(int X) {
		if (X == 0)
			return 0;
		return (X & 1) + bitSet(X >> 1);
	}

}
