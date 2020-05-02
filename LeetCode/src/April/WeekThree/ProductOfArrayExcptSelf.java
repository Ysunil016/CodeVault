package April.WeekThree;

public class ProductOfArrayExcptSelf {

	public static void main(String[] args) {
		int[] arrr = { 1, 2, 3, 4 };
		productExceptSelf(arrr);
	}

	public static int[] productExceptSelf(int[] nums) {

		int[] output = new int[nums.length];
		int prod = 1;
		for (int i = 0; i < nums.length; i++) {
			output[i] = 1;
			output[i] *= prod;
			prod *= nums[i];
		}

		prod = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			output[i] *= prod;
			prod *= nums[i];
		}

		for (int x : output)
			System.out.print(x + " ");

		return nums;
	}

}
