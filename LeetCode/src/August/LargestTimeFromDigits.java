package August;

public class LargestTimeFromDigits {

	public static void main(String[] args) {
		System.out.println(largestTimeFromDigits(new int[] { 1, 2, 3, 4 }));
	}

	private static boolean bound(int maxBound, int index, int[] a) {
		int max = -1;
		for (int i = index; i < a.length; i++)
			if (a[i] <= maxBound && (max == -1 || a[max] < a[i]))
				max = i;
		if (max == -1)
			return false;
		// swap it put at correct position
		int temp = a[max];
		a[max] = a[index];
		a[index] = temp;
		return true;
	}

	public static String largestTimeFromDigits(int[] a) {
		boolean res = (bound(2, 0, a) && (a[0] == 2 ? bound(3, 1, a) : bound(9, 1, a)) && bound(5, 2, a)
				&& bound(9, 3, a)) || (bound(1, 0, a) && bound(9, 1, a) && bound(5, 2, a) && bound(9, 3, a));

		if (!res)
			return new String();

		StringBuilder sb = new StringBuilder();

		return sb.append(String.valueOf(a[0])).append(String.valueOf(a[1])).append(':').append(String.valueOf(a[2]))
				.append(String.valueOf(a[3])).toString();

	}
}
