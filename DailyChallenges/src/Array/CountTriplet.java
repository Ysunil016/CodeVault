package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountTriplet {

	public static void main(String[] args) {
		List<Long> arr = new ArrayList<Long>();
		arr.add((long) 1);
		arr.add((long) 5);
		arr.add((long) 5);
		arr.add((long) 25);
		arr.add((long) 125);
		System.out.println(countTriplets(arr, 5));
	}

	static long countTriplets(List<Long> arr, long r) {
		long rC = 0;
		HashSet<Long> hSet = new HashSet<>();
		for (int i = 0; i < arr.size(); i++) {
			hSet.add(arr.get(i));
		}
		for (int i = 0; i < arr.size(); i++) {
			Long X = arr.get(i);

		}
		return rC;
	}

}
