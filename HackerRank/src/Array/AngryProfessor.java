package Array;

public class AngryProfessor {

	public static void main(String[] args) {
		System.out.println(angryProfessor(4, new int[] { -1, 2, 0, -1, 3 }));
	}

	static String angryProfessor(int k, int[] a) {
		int totalOnTime = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= 0)
				totalOnTime++;
		}
		System.out.println(totalOnTime);
		return (totalOnTime >= k) ? "NO" : "YES";

	}

}
