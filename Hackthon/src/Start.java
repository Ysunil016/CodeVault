import java.util.ArrayList;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> newh = new ArrayList<Integer>();
		newh.add(1);
		newh.add(2);
		newh.add(2);
		newh.add(1);
		System.out.println(good_triplets(newh, 4));

	}

	static long good_triplets(ArrayList<Integer> arr, int n) {
		int i, j, k, count = 0;
		for (i = 1; i <= n; i++) {
			for (j = i + 1; j <= n; j++) {
				for (k = j + 1; k <= n; k++) {
					if (getIfGood(arr.get(i - 1), arr.get(j - 1), arr.get(k - 1)))
						count += 6;
				}
			}
		}

		return count;

	}

	static boolean getIfGood(int a, int b, int c) {
		int count = 0, sum = a + b + c;
		if (sum % a == 0)
			count++;
		if (sum % b == 0)
			count++;
		if (sum % c == 0)
			count++;
		if (count == 1)
			return true;
		return false;
	}
}
