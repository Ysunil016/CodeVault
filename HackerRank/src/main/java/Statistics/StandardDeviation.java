package Statistics;

import java.util.Scanner;

public class StandardDeviation {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scan.nextInt();
		int[] arr = new int[t];
		int sum = 0;
		for (int i = 0; i < t; i++) {
			arr[i] = scan.nextInt();
			sum += arr[i];
		}
		System.out.println(getSD(arr, sum, t));
	}

	static double getSD(int[] arr, int sum, int count) {
		int mean = sum / count;
		double sd = 0;
		for (int i = 0; i < count; i++) {
			sd += Math.pow((arr[i] - mean), 2);
		}
		return (double) Math.round(Math.sqrt(sd / count) * 10) / 10;
	}

}
