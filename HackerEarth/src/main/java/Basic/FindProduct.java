package Basic;

import java.util.Scanner;

public class FindProduct {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int count = scan.nextInt();
		long ans = 1;
		for (int i = 1; i <= count; i++) {
			ans = (long) ((scan.nextInt() * ans) % (Math.pow(10, 9) + 7));
		}
		System.out.println(ans);
	}
}
