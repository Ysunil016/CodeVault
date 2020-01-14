package Array;

import java.util.Scanner;

public class BinaryQuery {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int arC = scan.nextInt();
		int qC = scan.nextInt();
		int[] ar = new int[arC];
		scan.nextLine();
		for (int i = 0; i < arC; i++) {
			ar[i] = scan.nextInt();
		}
		for (int i = 0; i < qC; i++) {
			int qT = scan.nextInt();
			if (qT == 0)
				System.out.println(binaryQueryOddEven(ar, scan.nextInt(), scan.nextInt()));
			else if (qT == 1)
				ar = binaryQueryFlip(ar, scan.nextInt());
		}
	}

	static int[] binaryQueryFlip(int[] arr, int index) {
		index--;
		if (arr[index] == 1)
			arr[index] = 0;
		else
			arr[index] = 1;
		return arr;
	}

	static String binaryQueryOddEven(int[] arr, int x, int y) {
		if (arr[y - 1] == 1)
			return "ODD";
		else
			return "EVEN";
	}

}
