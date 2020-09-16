package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BetweenTwoSets {

	public static void main(String[] args) {
		System.out.println(getTotalX(Arrays.asList(1, 3), Arrays.asList(12, 18)));
	}

	public static int getTotalX(List<Integer> a, List<Integer> b) {
		// Making Sure, that Elements are Sorted.
		Collections.sort(a);
		Collections.sort(b);

		int startElement = a.get(a.size() - 1);
		int endElement = b.get(0);

		int finalFactorCount = 0;
		while (startElement <= endElement) {
			if (checkForValidation(startElement, a, b)) {
				finalFactorCount++;
			}
			startElement += 1;
		}

		return finalFactorCount;
	}

	private static boolean checkForValidation(int element, List<Integer> a, List<Integer> b) {
		for (int i = 0; i < a.size(); i++) {
			if ((element % a.get(i)) != 0)
				return false;
		}
		for (int i = 0; i < b.size(); i++) {
			if ((b.get(i) % element) != 0)
				return false;
		}
		return true;
	}

}
