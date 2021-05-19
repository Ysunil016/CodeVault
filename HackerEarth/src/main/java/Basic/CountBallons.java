package Basic;

import java.util.Scanner;

public class CountBallons {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

//		int testCase = scan.nextInt();
//		scan.nextLine();
//		for (int i = 0; i < testCase; i++) {
//			int aC = scan.nextInt();
//			int bC = scan.nextInt();
//			int ques = scan.nextInt();
//			int[] a = new int[ques];
//			int[] b = new int[ques];
//			for (int j = 0; j < ques; j++) {
//				a[j] = scan.nextInt();
//				b[j] = scan.nextInt();
//			}
//			System.out.println(bCost(aC, bC, a, b, ques));
//		}

		int[] a = { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0 };
		int[] b = { 1, 1, 1, 0, 1, 0, 1, 1, 1, 0 };
		System.out.println(bCost(9, 6, a, b, 10));

	}

	static int bCost(int aC, int bC, int[] a, int[] b, int ques) {
		int sumA = 0;
		int sumB = 0;

		for (int i = 0; i < ques; i++) {
			if (a[i] == 1) {
				sumA++;
			}
			if (b[i] == 1) {
				sumB++;
			}
		}
		System.out.println(sumA);
		System.out.println(sumB);

		if (sumA > sumB) {
			sumA *= Math.min(aC, bC);
			sumB *= Math.max(aC, bC);

		} else {
			sumB *= Math.min(aC, bC);
			sumA *= Math.max(aC, bC);
		}
		System.out.println(sumA);
		System.out.println(sumB);

		return sumA + sumB;
	}

}
