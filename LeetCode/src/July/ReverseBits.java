package July;

public class ReverseBits {

	public static void main(String[] args) {
		System.out.println(reverseBits(255));
	}

	public static int reverseBits(int n) {
		int res = 0;
		int t = 32;
		while (--t > 0) {
			res |= (n & 1);
			n = n >> 1;
			res = res << 1;
		}
		res |= (n & 1);
		return res;
	}

}
