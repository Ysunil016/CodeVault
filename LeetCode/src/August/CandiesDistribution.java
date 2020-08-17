package August;

public class CandiesDistribution {

	public static void main(String[] args) {
		for (int x : distributeCandies(60, 4)) {
			System.out.print(x + " ");
		}
	}

	public static int[] distributeCandies(int candies, int num_people) {
		int[] result = new int[num_people];

		int additive = 1;
		int counter = 0;
		int remainingCandies = candies;
		while (remainingCandies != 0) {
			if (counter == num_people) {
				counter = 0;
				continue;
			}

			if (additive <= remainingCandies) {
				result[counter] += additive;
				remainingCandies -= additive;
				additive++;
				counter++;
			} else {
				result[counter] += remainingCandies;
				break;
			}

			System.out.println();
			for (int x : result) {
				System.out.print(x + " ");
			}
			System.out.println();

		}

//		System.out.println();
//		for (int x : result) {
//			System.out.print(x + " ");
//		}
//		System.out.println();

		return result;
	}

}
