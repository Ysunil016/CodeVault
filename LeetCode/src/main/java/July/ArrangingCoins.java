package July;

public class ArrangingCoins {

	public static void main(String[] args) {
		System.out.println(arrangeCoins(20));
	}

	public static int arrangeCoins(int n) {
		int Count = 0;
		int Res = 1;
		while (n - Res >= 0) {
			n -= Res;
			Res += 1;
			Count++;
		}
		return Count;
	}

}
