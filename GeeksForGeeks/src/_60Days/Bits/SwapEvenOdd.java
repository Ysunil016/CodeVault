package _60Days.Bits;

public class SwapEvenOdd {

	public static void main(String[] args) {
		System.out.println(getSwap(23));
	}

	static int getSwap(int num) {
		// Get all Even Bits
		int evenBits = num & 0xAAAAAAAA;
		// Get all Odd Bits
		int oddBits = num & 0x55555555;

		// Shifting even -> Right
		evenBits = evenBits >> 1;

		// Shifting even -> Left
		oddBits = oddBits << 1;

		// Combine Two
		num = evenBits | oddBits;

		return num;
	}

}
