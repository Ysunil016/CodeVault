package Array;

import java.util.Scanner;

public class MonkRotate {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tC = scan.nextInt();
		for (int i = 0; i < tC; i++) {
			int count = scan.nextInt();
			int rotation = scan.nextInt();
			int[] ar = new int[count];
			for (int j = 0; j < count; j++) {
				ar[j] = scan.nextInt();
			}
			for (int k = 0; k < rotation; k++) {
				ar = getRotation(ar, count);
			}
			for (int z = 0; z < count; z++) {
				System.out.print(ar[z] + " ");
			}

		}
	}

	static int[] getRotation(int[] ar, int count) {
		int t = ar[count - 1];
		for (int i = count - 1; i >= 1; i--) {
			ar[i] = ar[i - 1];
		}
		ar[0] = t;
		return ar;
	}

}
