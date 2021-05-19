package August;

public class PowerOfFour {

	public static void main(String[] args) {
		System.out.println(isPower(256));
	}

	private static boolean isPower(int X) {
		return ((Math.log10(X) / Math.log10(4)) % 1 == 0) ? true : false;
	}

}
