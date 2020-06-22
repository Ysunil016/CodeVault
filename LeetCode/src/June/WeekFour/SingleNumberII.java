package June.WeekFour;

public class SingleNumberII {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 5, 2 };
		System.out.println(singleNumber(arr));
	}

	public static int singleNumber(int[] nums) {
		int Ones = 0;
		int Twos = 0;
		int commonBits;
		for (int i = 0; i < nums.length; i++) {
			Twos = Twos | (Ones & nums[i]); // one & arr[i]" gives the bits that are there in both 'ones' and new
											// element from arr[]. We add these bits to 'twos' using bitwise OR
			Ones = Ones ^ nums[i];
			commonBits = ~(Ones & Twos);
			Ones &= commonBits;
			Twos &= commonBits;
		}
		return Ones;
	}

}