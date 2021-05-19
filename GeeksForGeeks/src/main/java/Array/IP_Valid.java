package Array;

public class IP_Valid {

	public static void main(String[] args) {
		String ipAddr = "172.16.251.12";
		System.out.println(isIpValid(ipAddr));
	}

	static boolean isIpValid(String inAddress) {

		String[] inAChar = inAddress.split("\\.");

		//Checking for 4 Octanes
		if (inAChar.length != 4)
			return false;

		//Checking a Free Hold . at the End
		if (inAddress.charAt(inAddress.length() - 1) == '.')
			return false;

		for (int i = 0; i < inAChar.length; i++) {
			try {
				//Checking if Octane is a Number
				int num = Integer.valueOf(inAChar[i]);
				
				//Checking if Octane is <0,255>
				if (num < 0 || num > 255)
					return false;

				//Checking if Octane Does'nt Start with Zero
				if (inAChar[i].length() != 1 && inAChar[i].charAt(0) == '0')
					return false;

			} catch (Exception e) {
				return false;
			}

		}

		return true;
	}

}
