package Array;

import java.util.HashSet;
import java.util.Scanner;

public class HappyNumber {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int in = scan.nextInt();
		System.out.println(isHappy(in));
	}

	static boolean isHappy(int in) {
		HashSet<Integer> repStore = new HashSet<Integer>();
		while (in != 1) {
			if (repStore.contains(in))
				return false;
			repStore.add(in);
			in = getSq(in);
		}
		if (in == 1) {
			return true;
		} else {
			return false;
		}
	}

	static int getSq(int num) {
		int t = num;
		int sum = 0;
		while (t != 0) {
			sum += (t % 10) * (t % 10);
			t = t / 10;
		}
		return sum;
	}

}
