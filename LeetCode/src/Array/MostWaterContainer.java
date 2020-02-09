package Array;

public class MostWaterContainer {

	public static void main(String[] args) {
		int[] data = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(getMaxArea(data));
		;
	}

	static int getMaxArea(int[] arr) {
		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int first = arr[i];
				int second = arr[j];
				int area = (Math.min(first, second)) * (j - i);
				if (area > maxArea)
					maxArea = area;
			}
		}

		return maxArea;
	}
}
