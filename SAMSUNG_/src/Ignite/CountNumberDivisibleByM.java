package Ignite;

public class CountNumberDivisibleByM {

	public static void main(String[] args) {

		int[] numRange = { 25, 100 };
		int divibleBy = 30;
		
		
		System.out.println(getDivisibilityCount(numRange[0], numRange[1], divibleBy));

	}

	// Function Returns the Count of Elements Divisible by "divisibleBy" in Range --
	// Optamized
	static int getDivisibilityCount(int startRange, int endRange, int divibleBy) {
		int divCount = 0;

		// Looping Until we Reach to Range End..
		while (startRange <= endRange) {

			// If startRange Found Divisible to divibleBy, then Just Increment startRange to
			// Next Divisible
			// Number
			if (startRange % divibleBy == 0) {
				divCount++;
				startRange += divibleBy;
			} else
				startRange++;
		}
		return (divCount);
	}

}
