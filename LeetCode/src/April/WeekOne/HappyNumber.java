package April.WeekOne;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(73));
	}

	static boolean isHappy(int n) {
		return ok(n);
	}

	static int firstSum = Integer.MAX_VALUE;

	static boolean ok(int n) {

		int temp = n;
		int sum = 0;
		while (temp != 0) {
			sum += Math.pow(temp % 10, 2);
			temp /= 10;
		}

		if (sum == 4)
			return false;

		if (sum < firstSum)
			firstSum = sum;

		if (sum == 1)
			return true;
		else
			return ok(sum);
	}

}
