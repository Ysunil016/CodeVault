package Array;

public class LargestRectangle {

	public static void main(String[] args) {
		int[] arr = { 11, 11, 10, 10, 10 };
		System.out.println(getLargestRectangle(arr));
	}

	// Finding Max Element for an Building Given an Array of Heights.
	// Condition is Rectangle Area will be Counters in Increments i -> i+1 -> i+2
	// And Also we have to find the max of all the concurrent area found by
	// comparing each and every heights form the building.
	private static long getLargestRectangle(int[] arr) {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int areaOfRectangle = arr[i];
			int initHeight = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (initHeight <= arr[j])
					areaOfRectangle += initHeight;
				else
					break;
			}
			if (i > 0)
				for (int k = i - 1; k >= 0; k--) {
					if (initHeight <= arr[k])
						areaOfRectangle += initHeight;
					else
						break;
				}

			// Checking for Every Height, is it more from our last stored??
			result = Math.max(result, areaOfRectangle);
		}

		return result;
	}

}
