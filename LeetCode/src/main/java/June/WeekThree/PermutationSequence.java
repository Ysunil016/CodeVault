package June.WeekThree;

import java.util.ArrayList;

public class PermutationSequence {

	public static void main(String[] args) {
		int n = 3;
		int k = 3;
		System.out.println(findPermutation(n, k));
	}

	private static String findPermutation(int n, int k) {
		int[] fact = new int[n];
		fact[0] = 1;
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i < n; i++) {
			fact[i] = i * fact[i - 1];
		}
		for (int i = 1; i <= n; i++)
			l.add(i);

		k--;

		StringBuilder res = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			int index = k / fact[i];
			res.append("").append(l.remove(index));
			k = k % fact[i];
		}
		return new String(res);
	}

}
