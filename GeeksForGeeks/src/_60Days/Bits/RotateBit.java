package _60Days.Bits;

public class RotateBit {

	public static void main(String[] args) {
		System.out.println(getRotatedNumber(10, 10));
	}

	static int getRotatedNumber(int number, int steps) {
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

}
