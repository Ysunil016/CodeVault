package Triplets;

import java.util.Arrays;
import java.util.HashSet;

public class Start {

	public static void main(String[] args) {
//		1,53,77,8,28,33,98,81,35,13,65,14,63,36,25,69,15,94,29,1,17,95,5,4,51,98,88,23,5,82,52,66,16,37,38,44,97,71,28,37,58,77,97,94,4,9,31,45,75,35,42,99,68,12,60,57,8,95,68,13,30,6,62,42,65,82,52,67,21,12,71,90,31,38,57,16,90,40,79,6,72,19,54,23,89,60,26,70,20,44,66,34,26,63,50,59,47,85,17,72

		long input[] = { 1, 1, 5, 4, 3, 6, 6, 5, 9, 10 };

//		long input[] = { 1, 1, 2, 2, 3, 4 };

		System.out.println(solve(input));
	}

	static long solve(long[] input) {

		Arrays.sort(input);
		HashSet<String> hashStore = new HashSet<String>();
		long uCount = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				for (int k = j + 1; k < input.length; k++) {
					String sum = input[i] + "" + input[j] + "" + input[k];
					if (input[i] != input[j] && input[j] != input[k] && input[i] != input[k]) {
						if (!hashStore.contains(sum)) {
							hashStore.add(sum);
							if (input[i] < input[j] && input[j] < input[k] && input[i] < input[k]) {
								if (i < j && j < k && i < k)
									uCount++;
							}
						}

					}
				}
			}
		}

		return uCount;
	}

}
