package July;

public class AngleBWHandsOfClock {

	public static void main(String[] args) {
		System.out.println(angleClock(12, 30));
	}

	public static double angleClock(int hour, int minutes) {
		if (hour == 12)
			hour = 0;
		double angleDifference = Math.abs(hour * 30 + minutes * 0.5 - minutes * 6);
		return Math.min(angleDifference, 360 - angleDifference);
	}

}
