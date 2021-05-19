package May.WeekFour;

public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int r : countBits(16)) {
			System.out.print(r + " ");
		}
	}

	public static int[] countBits(int nums) {
		int[] arr = new int[nums + 1];
		if (nums == 0) {
			return new int[] { 0 };
		}
		if (nums == 1) {
			return new int[] { 0, 1 };
		}
		arr[0] = 0;
		arr[1] = 1;
		// Pattern Recognized
		for (int i = 2; i <= nums; i++) {
			if (i % 2 == 0) {
				arr[i] = arr[i / 2];
			} else {
				arr[i] = arr[i / 2] + 1;
			}
		}
		return arr;
	}

}
