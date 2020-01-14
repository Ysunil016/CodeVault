package Array;

import java.util.Scanner;

public class HelpJarvis {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tC = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < tC; i++) {
			String num = scan.next();
			System.out.println(isContinous(num));
		}

	}

	static String isContinous(String num) {
		char[] ar = num.toCharArray();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < ar.length; i++) {
			int count = Integer.parseInt(String.valueOf(ar[i]));
			if(count==min || count==max)
				return "NO";
			if (count < min)
				min = count;
			if (count > max)
				max = count;
		}
		if (ar.length == 1)
			return "YES";

		if (max - min == 0)
			return "NO";

		if (ar.length == (max - min + 1))
			return "YES";
		else
			return "NO";
	}

}
