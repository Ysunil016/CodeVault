package com.Start;

public class Largest_Rectangle {

	public static void main(String[] args) {
		int[] height = { 1, 3, 5, 4, 6, 7 };

		for (int i = 0; i < height.length; i++) {
			int currentMax = 0;
			int tempMax = 0;
			for (int j = i; j < height.length; j++) {
				if (height[i] <= height[j]) {
					tempMax += 1;
				} else {
					j = height.length - 1;
				}
				if (currentMax < tempMax)
					currentMax = tempMax;
			}
		}

	}

}
