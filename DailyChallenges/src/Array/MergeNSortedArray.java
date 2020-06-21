package Array;

public class MergeNSortedArray {

	public static void main(String[] args) {
		int[][] arr = { { 3, 5, 7 }, { 0, 6 }, { 0, 6, 28 } };
		int elementCount = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				elementCount++;
			}
		}
		System.out.println(elementCount);
		int[] counterHolder = new int[arr.length];
		int[] Result = new int[elementCount];

		for (int i = 0; i < elementCount; i++) {
			int maxIndex = 0;
			int MAX = 0;
			for (int j = 0; j < arr.length; j++) {
				// Finding Max with Index
		
			}

		}
	}

}
