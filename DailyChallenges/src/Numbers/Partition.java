package Numbers;

public class Partition {

	public static void main(String[] args) {
		System.out.println(minPartValue(11));
		System.out.println(minPartValue(31));
		System.out.println(minPartValue(45));
		System.out.println(minPartValue(46));
		System.out.println(minPartValue(78));
		System.out.println(minPartValue(88));
		System.out.println(minPartValue(98));
	}

	private static int minPartValue(int num) {
		int fResult = num;
		for (int i = num; i > 0; i--) {
			int x = num - i;
			if (x % 2 == 0 && i % 3 == 0) {
				fResult = Math.min(fResult, Math.abs(x - i));
			}
			if (x % 3 == 0 && i % 2 == 0) {
				fResult = Math.min(fResult, Math.abs(x - i));
			}
		}
		return fResult;
	}

}
