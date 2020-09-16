package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestSubArray {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int count = scan.nextInt();
		List<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < count; i++)
			arr.add(scan.nextInt());

		System.out.println(longestSubarray(arr));
	}

	public static int longestSubarray(List<Integer> arr) {
		int finalMax = 1;
		int currentMax = 1;
		int lastElement = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			if (Math.abs(arr.get(i) - lastElement) <= 1) {
				currentMax++;
				finalMax = Math.max(finalMax, currentMax);
			} else {
				lastElement = arr.get(i);
				currentMax = 1;
			}
		}
		return finalMax;
	}

}
