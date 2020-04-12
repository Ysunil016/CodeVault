package XMaths;

import java.util.Scanner;

public class Down2Zero {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		int tc = scan.nextInt();
//		for (int i = 0; i < tc; i++)
//			System.out.println(round2Zero(scan.nextInt()));

		System.out.println(round2Zero(65536));
//			
	}

	static int round2Zero(int x) {
		int counter = 0;
		while (x != 1) {
			int[] r = findMul(x);
			if (r[0] != 0) {
				x = Math.max(r[0], r[1]);
			} else
				x = x - 1;
			counter++;
		}

		return ++counter;
	}

	static int[] findMul(int x) {
		int sqrt = sqrt(x) + 1;
		int[] res = new int[2];
		if (x != sqrt)
			while (sqrt > 1) {
				double fN = x / sqrt;
				if (isInteger(fN) && (fN * sqrt == x)) {
					res[0] = sqrt;
					res[1] = (int) fN;
					return res;
				}
				sqrt--;
			}
		return res;
	}

	static boolean isInteger(double x) {
		if (Math.floor(x) == x) {
			return true;
		}
		return false;
	}

	static int sqrt(int x) {
		return (int) Math.sqrt(x);
	}

	static void all(int x) {
		int t = x;
		while (x != 0) {
			double f = (float) t / x;
			if (isInteger(f))
				System.out.println(f + " at " + x);
			x--;
		}
	}

}
