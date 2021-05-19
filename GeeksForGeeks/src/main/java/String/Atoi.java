package String;

public class Atoi {

	public static void main(String[] args) {
		System.out.println(atoi("234565"));
		System.out.println(atoi("2345ab"));
	}

	static int atoi(String str) {
		try {
			int val = Integer.valueOf(str);
			return val;
		} catch (Exception e) {
			return -1;
		}
	}

}
