package String;

public class ReverseWord {

	public static void main(String[] args) {
		String in = "ad.sdsd.dsdd";
		reverseWords(in);
	}

	public static void reverseWords(String sdA) {
		String[] sd = sdA.split("\\.");
		for (int i = sd.length - 1; i > 0; i--)
			System.out.print(sd[i] + ".");
		System.out.print(sd[0]);
	}

}
