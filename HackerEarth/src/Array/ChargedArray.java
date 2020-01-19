package Array;

import java.util.Scanner;

public class ChargedArray {

//	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tC = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < tC; i++) {
			int x = scan.nextInt();
			int[] tJ = new int[x];
			for (int j = 0; j < x; j++) {
				tJ[j] = scan.nextInt();
			}
			System.out.println(getCA(tJ));
		}
	}

	static int getCA(int[] ar) {
		int total = 0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = i; j < ar.length; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print(ar[k] + " ");
				}
				System.out.println();
			}
		}

		return total;
	}

}
