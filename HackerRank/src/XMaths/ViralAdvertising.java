package XMaths;

public class ViralAdvertising {

	public static void main(String[] args) {
		System.out.println(viralAdvertising(5));
	}

	static int viralAdvertising(int n) {
		double peopleShare = 5;
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += (peopleShare / 2);
			System.out.println(result);
			peopleShare = Math.floor(peopleShare / 2) * 3;
		}
		return result;
	}
}
