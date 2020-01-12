package Basic;

import java.util.Scanner;

public class CountDivisor {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int l = scan.nextInt();
		int r = scan.nextInt();
		int k = scan.nextInt();
		System.out.println(countDivisor(l, r, k));
	}

	static int countDivisor(int l, int r, int k) {
		int count = 0;
		for (int i = l; i <= r; i++) {
			if (i % k == 0)
				count++;
		}
		return count;
	}

}
