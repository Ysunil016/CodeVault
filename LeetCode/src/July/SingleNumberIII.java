package July;

public class SingleNumberIII {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 2, 5, 5, 3, 4, 8 };
		int[] finalOutput = singleNumber(arr);
		System.out.println(finalOutput[0] + " and " + finalOutput[1]);
	}

	public static int[] singleNumber(int[] nums) {
		int[] result = { 0, 0 };

		int difference = 0;
		for (int num : nums) {
			difference ^= num;
		}
		difference &= -difference;
	
		for (int num : nums) {
			if ((num & difference) == 0) {
				result[0] ^= num;
			} else {
				result[1] ^= num;
			}

		}

		return result;
	}
}
