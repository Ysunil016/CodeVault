package Company;

public class SearchApartment {

	public static void main(String[] args) {
		int[] ar = { 1, 1, -3, 2, -4, 3 };
		int[] res = solve(6, ar);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}

	static int[] solve(int size_of_magor, int[] elements_of_magor) {
		int[] res = { 0, 0 };
		int left = 0;
		int end = size_of_magor - 1;
		int[] temp = elements_of_magor;
		while (left < end) {
			if (elements_of_magor[left] < 0)
				temp[left] = 0;
			if (elements_of_magor[left] > 0 && elements_of_magor[left + 1] > 0) {
				elements_of_magor[left + 1] = elements_of_magor[left] + elements_of_magor[left + 1];
				elements_of_magor[left] = -1;
				temp[left] = 0;
				res[0]--;
			}
			left++;
			res[0]++;
		}
		res[0]++;
		for (int i = 0; i < size_of_magor; i++) {
			res[1] += temp[i];
		}
		return res;
	}

}
