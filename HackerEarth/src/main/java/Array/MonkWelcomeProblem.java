package Array;

import java.util.Scanner;

public class MonkWelcomeProblem {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int aC = scan.nextInt();
		scan.nextLine();
		int[] arA = new int[aC];
		int[] arB = new int[aC];
		for (int i = 0; i < aC; i++) {
			arA[i] = scan.nextInt();
		}
		for (int i = 0; i < aC; i++) {
			arB[i] = scan.nextInt();
		}

		int[] res = getAdder(arA, arB);
		for (int i = 0; i < aC; i++) {
			System.out.print(res[i] + " ");
		}

	}

	static int[] getAdder(int[] A, int[] B) {
		for (int i = 0; i < A.length; i++) {
			A[i] += B[i];
		}
		return A;
	}

}
