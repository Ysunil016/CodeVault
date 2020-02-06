package BitManipulation;

public class XOR {

	public static void main(String[] args) {
		byte a = 7; // 00000111 in binary
		byte b = 9; // 00001001 in binary

		// a ^ b, should give 00001110 -> 14
		System.out.println("XOR of A and B is " + (a ^ b));

		// a<<2 will give 00011100 i.e 28
		System.out.println("<< Left Shift of A by 2 is " + (a << 2));

		// a>>2 will give 00000001 i.e 1
		System.out.println(">> Right Shift of A by 2 is " + (a >> 2));

	}

}
