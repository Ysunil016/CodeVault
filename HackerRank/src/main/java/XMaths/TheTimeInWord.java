package XMaths;

public class TheTimeInWord {

	public static void main(String[] args) {
		System.out.println(timeInWords(3, 37));
	}

	static String[] hourTime = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
			"twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
			"twenty seven", "twenty eight", "twenty nine", "thirty", "thirty one", "thirty two", "thirty three",
			"thirty four", "thirty five", "thirty six", "thirty seven", "thirty eight", "thirty nine", "fourty",
			"fourty one", "fourty two", "fourty three", "fourty four", "fourty five", "fourty six", "fourty seven",
			"fourty eight", "fourty nine", "fifty", "fifty one", "fifty two", "fifty three", "fifty four", "fifty five",
			"fifty six", "fifty seven", "fifty eight", "fifty nine" };

	// Complete the timeInWords function below.
	static String timeInWords(int h, int m) {
		switch (m) {
		case 0: {
			return hourTime[h] + " o' clock";
		}
		case 15: {
			return "quarter past " + hourTime[h];
		}
		case 30: {
			return "half past " + hourTime[h];
		}
		case 45: {
			if (h == 12)
				return "quarter to 1";
			else
				return "quarter to " + hourTime[h + 1];
		}
		}

		if (m == 1) {
			return hourTime[m] + " minute past " + hourTime[h];
		}

		if (m < 30) {
			return hourTime[m] + " minutes past " + hourTime[h];
		}

		if (m > 30 && m < 60) {
			if (h == 12)
				return hourTime[(60 - m)] + " minutes to " + 1;
			else
				return hourTime[(60 - m)] + " minutes to " + hourTime[h + 1];
		}

		return "X";
	}

}
