package Array;

import java.util.TreeMap;

public class PermutationEquation {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1 };
		for (int x : permutationEquation(arr)) {
			System.out.print(x + " ");
		}
		;
	}

	static int[] permutationEquation(int[] p) {
		TreeMap<Integer, Integer> indexHash = new TreeMap<>();
		for (int i = 1; i <= p.length; i++) {
			indexHash.put(p[i - 1], i);
		}
		int counter = 0;
		for (int x : indexHash.keySet()) {
			p[counter] = indexHash.get(indexHash.get(x));
			counter++;
		}

		return p;
	}

}
