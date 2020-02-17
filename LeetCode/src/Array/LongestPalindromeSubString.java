package Array;

public class LongestPalindromeSubString {

	public static void main(String[] args) {
		String data = "klvxwqyzugrdoaccdafdfrvxiowkcuedfhoixzipxrkzbvpusslsgfjocvidnpsnkqdfnnzzawzsslwnvvjyoignsfbxkgrokzyusxikxumrxlzzrnbtrixxfioormoyyejashrowjqqzifacecvoruwkuessttlexvdptuvodoavsjaepvrfvbdhumtuvxufzzyowiswokioyjtzzmevttheeyjqcldllxvjraeyflthntsmipaoyjixygbtbvbnnrmlwwkeikhnnmlfspjgmcxwbjyhomfjdcnogqjviggklplpznfwjydkxzjkoskvqvnxfzdrsmooyciwulvtlmvnjbbmffureoilszlonibbcwfsjzguxqrjwypwrskhrttvnqoqisdfuifqnabzbvyzgbxfvmcomneykfmycevnrcsyqclamfxskmsxreptpxqxqidvjbuduktnwwoztvkuebfdigmjqfuolqzvjincchlmbrxpqgguwuyhrdtwqkdlqidlxzqktgzktihvlwsbysjeykiwokyqaskjjngovbagspyspeghutyoeahhgynzsyaszlirmlekpboywqdliumihwnsnwjc";
		int max = Integer.MIN_VALUE;
		String finalResult = "";
		if (data.length() == 1)
			System.out.println(data);
	
		char[] data2 = data.toCharArray();
		for (int i = 0; i <= data2.length; i++) {
			for (int j = i + 1; j <= data2.length; j++) {
				String result = getPalindromLength(data.substring(i, j));
				if (result.length() > max) {
					max = result.length();
					finalResult = result;
				}
			}
		}
		System.out.println(finalResult);

	}

	static String getPalindromLength(String sub) {
		char[] arr = sub.toCharArray();
		for (int i = 0; i < (arr.length) / 2 + 1; i++) {
			if (arr[i] != arr[arr.length - i - 1]) {
				return "";
			}
		}
		return new String(sub);
	}
}
