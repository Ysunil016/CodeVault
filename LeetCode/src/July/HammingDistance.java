package July;

public class HammingDistance {

	public static void main(String[] args) {
		System.out.println(getHammingDistance(1, 4));
	}

	private static int getHammingDistance(int X, int Y) {
		int t = 33;
		int r = 0;
		while (--t != 0) {
			int _X = X & 1;
			int _Y = Y & 1;
			if (_X != _Y) {
				r++;
			}
			X = X >> 1;
			Y = Y >> 1;
		}
		return r;
	}

}
