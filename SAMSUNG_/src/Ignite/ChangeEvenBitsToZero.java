package Ignite;

public class ChangeEvenBitsToZero {

	public static void main(String[] args) {
		System.out.println(changeAllEvenBitsTo_0(30));
	}

	static int changeAllEvenBitsTo_0(int num) {
		// Integer Holds 32 Bits in JVM
		// 0xAAAAAAAA - > 1010 1010 1010 1010 1010 1010 1010 1010
		// Making & NUM with 0xAAAAAAAA, will give Required Output

		return num & 0xAAAAAAAA;
	}

}
