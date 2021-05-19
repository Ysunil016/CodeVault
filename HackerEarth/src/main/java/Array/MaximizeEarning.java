package Array;

import java.util.Scanner;

public class MaximizeEarning {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int sN = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < sN; i++) {
			int bN = scan.nextInt();
			int cost = scan.nextInt();
			int[] ar = new int[bN];
			int bCount = 0;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < bN; j++) {
				ar[j] = scan.nextInt();
				if (ar[j] > max) {
					max = ar[j];
					bCount++;
				}
			}
			System.out.println(cost * bCount);
		}

	}

}
