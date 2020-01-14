package Array;

import java.util.Scanner;

public class MicroAndArrayUpdate {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int testCase = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < testCase; i++) {
			int arC = scan.nextInt();
			int key = scan.nextInt();
			int[] ar = new int[arC];
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < arC; j++) {
				ar[j] = scan.nextInt();
				if (min > ar[j])
					min = ar[j];
			}
			if (min > key)
				System.out.println(0);
			else
				System.out.println(key - min);

		}

	}
}
