package _60Days.Bits;

public class RotateBit {

	public static void main(String[] args) {
		System.out.println(getLeftRotatedNumber(16, 2));
		System.out.println(getRightRotatedNumber(16,2));
	}

	static int getLeftRotatedNumber(int number, int steps) {
		steps = steps % 32;
		for (int i = 0; i < steps; i++) {
			int lastBit = number & 0x80000000;
			if (lastBit != 0) {
				number = number << 1;
				number = number | 1;
			} else
				number = number << 1;
		}
		return number;
	}

	static int getRightRotatedNumber(int number, int steps) {
		steps = steps % 32;
		for (int i = 0; i < steps; i++) {
			int lastBit = number & 1;
			if (lastBit != 0) {
				number = number >> 1;
				number = number | 0x80000000;
			} else
				number = number >> 1;
		}
		return number;
	}

}
