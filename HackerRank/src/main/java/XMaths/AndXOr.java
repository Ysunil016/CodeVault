package XMaths;

public class AndXOr {

	public static void main(String[] args) {
		int[] arr = { 9, 8, 3, 5, 7 }; // 11
		System.out.println(andXorOr(arr));
	}

	static int andXorOr(int[] arr) {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
		
		}
		return result;
	}

	static int findV(int arr[], int L, int R) {
		System.out.println("LR [" + L + " , " + R + "]");

		int c = (arr[L] & arr[R]) ^ (arr[L] | arr[R]) & (arr[L] ^ arr[R]);
		System.out.println(c);

		return c;
	}
}
