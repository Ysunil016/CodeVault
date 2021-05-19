package Basic;

import java.util.Scanner;

public class Factorial {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int in = scan.nextInt();
		System.out.println(fact(in));
	}

	static int fact(int num) {
		if (num == 1)
			return 1;
		return num*fact(num - 1);
	}

}
