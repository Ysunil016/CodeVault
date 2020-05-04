package May.WorkOne;

public class NumberComplement {

	public static void main(String[] args) {
		System.out.println(getComplement(5000));
	}

	static int getComplement(int number) {
		// Finding all the Bits with which Operation is Needed
		int bitsNeeded = (int) (Math.log(number) / Math.log(2)) + 1;
		int bit = 1;
		for (int i = 0; i < bitsNeeded; i++) {
			number = number ^ (bit);
			bit = bit << 1;
		}
		return number;
	}

}
