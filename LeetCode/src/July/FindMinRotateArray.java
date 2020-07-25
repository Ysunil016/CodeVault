package July;

public class FindMinRotateArray {

	public static void main(String[] args) {
//		int[] ar = { 5, 6, 0, 1, 2, 4 };
//		int[] ar = { 18, 19, 20, 0, 1, 4, 9, 12, 16, 17 };
		int[] ar = { 3, 3, 3, 3, 3, 3, 3, 3, 1, 3 };

		System.out.println(findMinOfAll(ar));
	}

	static int findMinOfAll(int[] rArr) {
		return bst(rArr, 0, rArr.length - 1);
	}

	static int bst(int[] rArr, int start, int end) {

		while (start < end) {
			int middleElement = start + (end - start) / 2;
			if (rArr[middleElement] == rArr[end]) {
				end--;
			} else if (rArr[middleElement] > rArr[end]) {
				start = middleElement + 1;
			} else {
				end = middleElement;
			}
		}
		return rArr[end];
	}

}
