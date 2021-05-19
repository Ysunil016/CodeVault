package Basic;

import java.util.Scanner;

public class Zoos {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String in = scan.next();
		if (isTrue(in.toCharArray())) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	static boolean isTrue(char[] in) {
		int Zs = 0;
		int Os = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == 'Z')
				Zs++;
			if (in[i] == 'O')
				Os++;
		}

		if (Zs * 2 == Os)
			return true;
		else
			return false;
	}

}
