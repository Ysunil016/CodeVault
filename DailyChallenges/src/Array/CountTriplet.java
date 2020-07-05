package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountTriplet {

	public static void main(String[] args) {
		List<Long> arr = new ArrayList<Long>();
		arr.add((long) 1);
		arr.add((long) 5);
		arr.add((long) 5);
		arr.add((long) 25);
		arr.add((long) 125);
		System.out.println(countTriplets(arr, 1));
	}

	static long countTriplets(List<Long> arr, long r) {
		long rC = 0;

		int n = arr.size();

		for (int j = 1; j < n - 1; j++) {
			int i = j - 1, k = j + 1;

			while (i >= 0 && k < n - 1) {
				while (arr.get(j) % arr.get(i) == 0 && arr.get(k) % arr.get(j) == 0
						&& arr.get(j) / arr.get(i) == arr.get(k) / arr.get(j)) {
					rC++;
					k++;
					i--;
				}
				if (arr.get(j) % arr.get(i) == 0 && arr.get(k) % arr.get(j) == 0) {
					if (arr.get(j) / arr.get(i) < arr.get(k) / arr.get(j))
						i--;
					else
						k++;
				}

				// else if arr[j] is multiple of arr[i], then
				// try next k. Else, try previous i.
				else if (arr.get(j) % arr.get(i) == 0)
					k++;
				else
					i--;
			}
		}

		return rC;
	}

}
