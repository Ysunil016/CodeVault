package _30Days.WeekOne;

public class MoveZeros {

	public static void main(String[] args) {
		int[] arr = { 1,0,1 };
		moveZeroes(arr);
		for (int num : arr)
			System.out.print(num + " ");
	}

	public static void moveZeroes(int[] nums) {
		int I = 0;
		int J = 1;

		for (int Z = 0; Z < nums.length-1; Z++) {
			if (nums[J] != 0) {
				if (nums[I] == 0) {
					nums[I] = nums[J];
					nums[J] = 0;
					I++;
				}
			}
			J++;
		}
	}
}
