package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TripletCount {

	public static void main(String[] args) {

		List<Long> arr = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			arr.add((long) 1);

		System.out.println(countTriplets(arr, 1));

	}

	
	// O(n^3) - Bad Runtime
	static long countTriplets(List<Long> arr, long r) {
		Collections.sort(arr);
		long ResultCount = 0;
		for (int i = 0; i < arr.size() - 2; i++) {
			for (int j = i + 1; j < arr.size() - 1; j++) {
				for (int k = j + 1; k < arr.size(); k++) {
					if (arr.get(j) / arr.get(i) == r && arr.get(k) / arr.get(j) == r) {
						ResultCount++;
					}
				}
			}
		}

		return ResultCount;
	}

}
