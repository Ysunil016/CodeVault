package Array;

public class UtopiaTree {

	public static void main(String[] args) {
		System.out.println(utopianTree(5));
	}

	static int utopianTree(int n) {
		int height = 1; // Starting the Tree Height
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				height += 1;
			} else {
				height *= 2;
			}
		}

		return height;
	}

}
