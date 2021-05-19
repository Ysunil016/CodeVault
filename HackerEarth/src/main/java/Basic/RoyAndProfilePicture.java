package Basic;

import java.util.Scanner;

public class RoyAndProfilePicture {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int low = scan.nextInt();
		int testCase = scan.nextInt();
		for (int i = 0; i < testCase; i++) {
			System.out.println(getAcceptance(scan.nextInt(), scan.nextInt(), low));
		}
	}

	static String getAcceptance(int w, int h, int t) {
		if (w < t || h < t)
			return "UPLOAD ANOTHER";
		else {
			if (w == h)
				return "ACCEPTED";
			else
				return "CROP IT";
		}
	}

}
