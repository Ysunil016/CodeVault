package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class KittyTree {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int nodeCounts = sc.nextInt();
		int setCount = sc.nextInt();

		HashMap<Integer, ArrayList<Integer>> tressStore = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 1; i < nodeCounts; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			ArrayList<Integer> tr = tressStore.get(src);
			if (tr == null)
				tr = new ArrayList<Integer>();
			tr.add(dest);
			tressStore.put(src, tr);

			System.out.println(tressStore.get(src));
		}

		System.out.println("Making Set");

		for (int i = 0; i < setCount; i++) {
			int sCount = sc.nextInt();
			int[] count = new int[sCount];
			for (int j = 0; j < sCount; j++) {
				count[j] = sc.nextInt();
			}
			System.out.println(getCalculation(tressStore, count));
		}

	}

	private static int getCalculation(HashMap<Integer, ArrayList<Integer>> tree, int[] qSet) {
		int tSum = 0;
		if (qSet.length == 1)
			return 0;

		// Finding all Pairs
		for (int i = 0; i < qSet.length - 1; i++) {
			for (int j = i + 1; j < qSet.length; j++) {
				int a = qSet[i];
				int b = qSet[j];
				System.out.println(a + " and " + b);
				tSum += (a * b * uniquePathBetween(tree, a, b)) % (Math.pow(10, 9) + 7);
			}
		}
		return tSum;
	}

	private static int uniquePathBetween(HashMap<Integer, ArrayList<Integer>> tree, int nodeOne, int nodeTwo) {
		int tSum = 0;

		
		
		return tSum;
	}

}
