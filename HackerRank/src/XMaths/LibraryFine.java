package XMaths;

public class LibraryFine {

	public static void main(String[] args) {
		System.out.println(libraryFine(10, 6, 1995, 12, 7, 1990));
	}

	static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
		if (y1 > y2) {
			return 10000;
		}
		if (y1 < y2)
			return 0;

		if (m1 > m2) {
			return (m1 - m2) * 500;
		}

		if (m1 < m2) {
			return 0;
		}

		if (d1 > d2) {
			return (d1 - d2) * 15;
		}
		return 0;
	}

}
