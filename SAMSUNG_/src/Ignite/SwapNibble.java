package Ignite;

public class SwapNibble {

	public static void main(String[] args) {

		int A = 255;

		System.out.println(swapNibbleInByte(A));

	}

	static int swapNibbleInByte(int A) {
		int _4L = A & 0xF0; // 0x000000F0

		// Right Shifting to Make Right Most 8 Bits
		_4L = _4L >> 4;

		int _4R = A & 0xF; // 0x0000000F
		// Left Shifting to Make It a Bit with Other Nibble Empty

		_4R = _4R << 4;
		// Merging Two Bytes with Switched Nibbles
		return _4R | _4L;
	}

}
