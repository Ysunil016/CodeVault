package com.String;

import java.util.Scanner;

public class Start {
	static Scanner scan = new Scanner(System.in);
	static String deletedNode;
	static int insertedNodeInit;

	public static void main(String[] args) {
		StringBuilder absString = new StringBuilder();

		int test_count = scan.nextInt();
		for (int i = 0; i < test_count; i++) {
			int lastAction = 0;
			int actionKey = scan.nextInt();
			switch (actionKey) {
			case 1:
				absString = append(absString);
				System.out.println(absString);
				lastAction = 1;
				break;
			case 2:
				absString = delete(absString);
				lastAction = 2;
				break;
			case 3:
				print(absString);
				break;
			case 4:
				reverseOperations(absString, lastAction);
				break;
			default:
				break;
			}

		}

	}

	private static StringBuilder append(StringBuilder absString) {
		String inputString = scan.next();
		insertedNodeInit = absString.length();
		return absString.append(inputString);
	}

	private static StringBuilder delete(StringBuilder absString) {
		int position = scan.nextInt();
//		System.out.println("Length :: "+absString.length());
//		System.out.println(absString.length()-1-position);
//		System.out.println(absString.length()-1);
		deletedNode = absString.substring(absString.length() - position, absString.length());
		return absString.delete(absString.length() - position, absString.length());
	}

	private static void print(StringBuilder absString) {
		int position = scan.nextInt();
		System.out.println(absString.charAt(position-1));
	}

	private static void reverseOperations(StringBuilder absString, int lastAction) {
		switch (lastAction) {
		case 1:
			absString = absString.delete(insertedNodeInit, absString.length() - 1);
			break;
		case 2:
			absString = absString.append(deletedNode);
			break;

		default:
			break;
		}
	}
}
