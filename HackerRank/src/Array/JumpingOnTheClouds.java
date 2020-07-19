package Array;

public class JumpingOnTheClouds {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 0, 0, 1, 1, 0 };
		System.out.println(jumpingOnClouds(arr, 2));
	}

	static int jumpingOnClouds(int[] c, int k) {
		int result = 100;
		int jump = k % c.length;
		while (jump != 0) {
			if (c[jump] == 1) {
				result -= 3;
			} else {
				result -= 1;
			}
			jump = (jump + k) % c.length;
		}

		if (c[jump] == 1) {
			result -= 3;
		} else {
			result -= 1;
		}

		return result;
	}

}
