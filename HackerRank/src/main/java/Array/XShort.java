package Array;

import java.util.Scanner;

public class XShort {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int x = scan.nextInt();
		int y = scan.nextInt();
		int[][] n = new int[x][2];
		int[][] m = new int[y][2];

		for (int i = 0; i < x; i++) {
			n[i][0] = scan.nextInt();
			n[i][1] = scan.nextInt();
		}
		for (int i = 0; i < y; i++) {
			m[i][0] = scan.nextInt();
			m[i][1] = scan.nextInt();
		}

		System.out.println(getAllShorts(n, m));
	}

	private static int getAllShorts(int[][] shorts, int[][] player) {
		int count = 0;

		int sCount = shorts.length;
		int pCount = player.length;

		for (int i = 0; i < pCount; i++) {
			int start = player[i][0];
			int end = player[i][1];
			int x = 0;
			for (int j = 0; j < sCount; j++) {
				if ((shorts[j][0] >= start && shorts[j][1] <= end)) {
					x++;
				} else if (shorts[j][0] >= start && shorts[j][0] <= end) {
					x++;
				} else if (shorts[j][1] >= start && shorts[j][1] <= end) {
					x++;
				}else if(shorts[j][0] <= start && shorts[j][1] >= end) {
					x++;	
				}
			}
			count += x;
		}
		return count;
	}

}
