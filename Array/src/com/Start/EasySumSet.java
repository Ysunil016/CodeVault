package com.Start;

import java.util.HashSet;

public class EasySumSet {

	public static void main(String[] args) {
		HashSet<Integer> setStore = new HashSet<Integer>();
		int[] setOne = { 1, 2 };
		int[] setTwo = { 3, 4, 5 };

		for (int i = 0; i < setTwo.length; i++) {
			for (int j = 0; j < setOne.length; j++) {
				System.err.println(setTwo[i] + " and " + setOne[j]);
				setStore.add(setTwo[i] - setOne[j]);
			}
		}
		
		setStore.iterator().forEachRemaining(res->{
		
		});
		
		System.out.println(setStore);
	}
}
