package Array;

public class ValidateIP {

	public static void main(String[] args) {
//		System.out.println(isValid("222.111.111.111"));
//		System.out.println(isValid("5555..555"));
//		System.out.println(isValid("0000.0000.0000.0000"));
//		System.out.println(isValid("1.2.3.04"));
		System.out.println(isValid("0.0.0.0."));
		
	}

	static boolean isValid(String arg) {
		String[] octades = arg.split("\\.");
		if (octades.length != 4)
			return false;
		

		
		
		for (int i = 0; i < 4; i++) {
			try {
				int val = Integer.parseInt(octades[i]);
				if (val > 255 || val < 0) {
					return false;
				}
				if (octades[i].charAt(0) == '0' && octades[i].length() != 1)
					return false;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

}
