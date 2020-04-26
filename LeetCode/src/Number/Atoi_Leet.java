package Number;

/**
 * 
 * @author sunil016
 *
 */

public class Atoi_Leet {

	public static void main(String[] args) {
		System.out.println(myAtoi("-"));
	}

	public static int myAtoi(String str) {
		boolean isNegative = false;

		// String Integer Removing BackSpaces;
		str = str.strip();
		System.out.println(str);
		char[] strA = str.toCharArray();

		// Checking if there is No String Given.
		if(strA.length==0)
			return 0;
		
		int t = 0;
		// Declaring  StringBuilder as it's Mutable
		StringBuilder strBuild = new StringBuilder();
		if (strA[0] == '-') {
			strBuild.append(strA[t]);
			isNegative = true;
			t++;
		}
		if (strA[0] == '+') {
			strBuild.append(strA[t]);
			isNegative = false;
			t++;
		}

		// Iterating through Char Array
		while (t < strA.length) {
			if (strA[t] >= '0' && strA[t] <= '9') {
				strBuild.append(strA[t]);
			} else
				break;
			t++;
		}

		// Check if There is No Integer for Final Result
		if (strBuild.length() == 0)
			return 0;
		// Checking if String has Only Signs as +ve or -ve
		else if (strBuild.length() == 1) {
			if (strA[0] == '+' || strA[0] == '-')
				return 0;
			else return Integer.valueOf(new String(strBuild));
		} else {
			try {
				//Returning the Actual Ineteger
				return Integer.valueOf(new String(strBuild));
			} catch (Exception e) {
				//Catching all the as Per Not Valid Format Integer.
				if (isNegative)
					return Integer.MIN_VALUE;
				else
					return Integer.MAX_VALUE;
			}
		}
		}
	}

