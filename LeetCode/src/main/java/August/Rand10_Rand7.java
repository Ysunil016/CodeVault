package August;

public class Rand10_Rand7 {

	public static void main(String[] args) {
		System.out.println(rand10());
	}

	public static int rand10() {
		int rand40 = Integer.MAX_VALUE;
		while (rand40 >= 40) {
			rand40 = 7 * (rand7() - 1) + (rand7() - 1);
		}
		return rand40 % 10 + 1;
	}

	private static int rand7() {
		return (int) (Math.random() * 7);
	}

}
