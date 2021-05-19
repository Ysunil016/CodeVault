package August;

import java.util.HashMap;
import java.util.Map;

public class LargestCommonFactorChain {

	public static void main(String[] args) {
		System.out.println(largestComponentSize(new int[] { 4, 3, 2, 4, 5, 3 }));
	}

	public static int largestComponentSize(int[] A) {
		Map<Integer, Integer> parent = new HashMap<>();

		for (int num : A)
			for (int fact = 2; fact * fact <= num; fact++)
				if (num % fact == 0) {
					union(num, fact, parent);
					union(num, num / fact, parent);
				}

		int max = 1;
		Map<Integer, Integer> freq = new HashMap<>();
		for (Integer v : A) {
			int f = find(v, parent);
			if (freq.containsKey(f)) {
				freq.put(f, freq.get(f) + 1);
				max = Math.max(max, freq.get(f));
			} else
				freq.put(f, 1);
		}
		return max;
	}

	public static void union(int n, int m, Map<Integer, Integer> p) {
		int findN = find(n, p);
		int findM = find(m, p);
		if (findN < findM)
			p.put(findM, findN);
		else
			p.put(findN, findM);
	}

	public static int find(Integer i, Map<Integer, Integer> parent) {
		if (parent.get(i) == null)
			parent.put(i, i);
		while (i != parent.get(i))
			i = parent.get(i);
		return i;
	}

}
