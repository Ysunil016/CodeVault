package Array;

import java.util.Scanner;

public class LongATMQueue {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scan.nextInt();
		scan.nextLine();
		int[] ar = new int[N];
		int ex = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < N; i++) {
			ar[i] = scan.nextInt();
			if (ar[i] < ex) {
				res++;
			}
			ex = ar[i];
		}
		System.out.println(res);
	}

}
