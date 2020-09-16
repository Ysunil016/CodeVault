package Array;

import java.util.HashSet;

public class BeautifulTriplets {

	public static void main(String[] args) {
		System.out.println(beautifulTriplets(5, new int[] { 4, 2, 4, 6, 1, 4, 6, 7, 5, 4, 3, 6, 1, 4, 9, 4, 7, 8 }));
	}

	static int beautifulTriplets(int d, int[] arr) {
		int resultCount = 0;

		HashSet<Integer> hashStore = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			hashStore.add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			if (hashStore.contains(arr[i] + d) && hashStore.contains(arr[i] + 2 * d)) {
				resultCount++;
			}
		}

		return resultCount;
	}

	static int beautifulTripletsBruteForce(int d, int[] arr) {
		int resultCount = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if ((arr[j] - arr[i] == d) && (arr[k] - arr[j]) == d) {
						resultCount++;
					}
				}
			}
		}
		return resultCount;
	}

}
