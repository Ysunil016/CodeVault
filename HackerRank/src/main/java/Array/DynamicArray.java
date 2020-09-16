package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArray {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int N = scan.nextInt();
		int Q = scan.nextInt();

		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++)
			arr.add(new ArrayList<Integer>());

		for (int i = 0; i < Q; i++) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			int V = scan.nextInt();

			dynamic(arr, A, B, V, N);
		}

	}

	static int lastAnswer = 0;

	static void dynamic(ArrayList<ArrayList<Integer>> arr, int a, int x, int y, int n) {
		if (a == 1) {
			int seqNumber = (x ^ lastAnswer) % n;
			ArrayList<Integer> seqList = arr.get(seqNumber);
			seqList.add(y);
			arr.add(seqList);
		} else {
			int seqNumber = (x ^ lastAnswer) % n;
			ArrayList<Integer> seqList = arr.get(seqNumber);
			lastAnswer = seqList.get(y % seqList.size());
			System.out.println(lastAnswer);
		}
	}

}
