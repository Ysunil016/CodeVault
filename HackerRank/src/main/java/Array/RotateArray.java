package Array;

public class RotateArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		for (int c : circularArrayRotation(arr, 2, new int[] { 1, 2 })) {
			System.out.print(c + " ");
		}
	}

	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		
		// Optimising for K > Length 
		k = k % a.length;
		
		// Iteratin for K Times
		for (int i = 0; i < k; i++) {
			int lastElement = a[a.length - 1];
			for (int j = a.length - 1; j > 0; j--) {
				a[j] = a[j - 1];
			}
			a[0] = lastElement;
		}
		int[] result = new int[queries.length];
		int t = 0;
		for (int index : queries) {
			result[t++] = a[index];
		}
		return result;
	}
}
