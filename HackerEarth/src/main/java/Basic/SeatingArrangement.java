package Basic;

import java.util.Scanner;

public class SeatingArrangement {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tC = scan.nextInt();
		for (int i = 0; i < tC; i++) {
			int number = scan.nextInt();
			int opSeat = getOppSeatNumber(number);
			System.out.println(opSeat + " " + getTypeBySeatNumber(opSeat));
		}
	}

	static int getOppSeatNumber(int seat) {
		int temp = seat;
		int rP = 0;
		while (temp != 0) {
			rP = temp % 12;
			temp = rP / 12;
		}
		if(rP==0)
			rP = 12;
		
		if (rP > 6) {
			int t = 12 - rP;
			int initL = seat + t;
			return (initL - rP + 1);
		} else {
			int initH = seat - rP + 1;
			if (initH % 6 == 0)
				return initH;
			else
				return (initH + 12 - rP);
		}
	}

	static String getTypeBySeatNumber(int seat) {
		int temp = seat;
		int rP = 0;
		while (temp != 0) {
			rP = temp % 6;
			temp = rP / 6;
		}
		switch (rP) {
		case 1:
			return "WS";
		case 2:
			return "MS";
		case 3:
			return "AS";
		case 4:
			return "AS";
		case 5:
			return "MS";
		case 0:
			return "WS";
		}
		return "";
	}

}
