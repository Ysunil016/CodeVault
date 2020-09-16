package XMaths;

public class BeautifulDayAtMovies {

	public static void main(String[] args) {
		System.out.println(beautifulDays(20, 25, 8));
	}

	static int beautifulDays(int X, int Y, int K) {
		int bDays = 0;
		for (int i = X; i <= Y; i++) {
			bDays += (Math.abs(i - reverseInteger(i)) % K == 0) ? 1 : 0;
		}
		return bDays;
	}

	static int reverseInteger(int num) {
		int X = 0;
		while (num != 0) {
			X *= 10;
			X += num % 10;
			num /= 10;
		}
		return X;
	}

}
