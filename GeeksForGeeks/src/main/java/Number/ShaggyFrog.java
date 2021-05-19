package Number;

public class ShaggyFrog {

	public static void main(String[] args) {
		System.out.println(isFrogAtRight(1));
		System.out.println(isFrogAtRight(7));
		System.out.println(isFrogAtRight(64));
	}

	static boolean isFrogAtRight(int number) {
		int start = 1;
		while (start < number) {
			start += start;
		}
		if (start == number)
			return true;
		else
			return false;
	}

}
