package Ignite;

public class SetBit_Integer {

	public static void main(String[] args) {
		System.out.println(get_1_BitCount(255));
	}

	static int get_1_BitCount(int num) {
		if (num == 0)
			return 0;

		// num & 1 - Checking if End Bit is 1 or 0
		// num >> 1 - Shifting num's bit by 1 at Right
		return (num & 1) + get_1_BitCount(num >> 1);

	}

}
