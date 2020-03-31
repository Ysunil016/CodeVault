package Heap;

import java.util.ArrayList;
import java.util.Scanner;

public class QHeap {
	static Scanner scan = new Scanner(System.in);

	static ArrayList<Integer> numsStore = new ArrayList<Integer>();

	public static void main(String[] args) {
		int queries = scan.nextInt();
		for (int i = 0; i < queries; i++) {
			int action = scan.nextInt();
			switch (action) {
			case 1:
				addElement(scan.nextInt());
				break;
			case 2:
				removeElement(scan.nextInt());
				break;
			case 3:
				System.out.println(peekElement());
				break;
			}

			for (int data : numsStore) {
				System.out.print(data + " ");
			}
			System.out.println();

		}
	}

	static void removeElement(int data) {

	}

	static void addElement(int data) {
		numsStore.add(data);

		int currentPos = numsStore.size();
		heapify(currentPos - 1);
	}

	static int peekElement() {
		return numsStore.get(0);
	}

	static void heapify(int pos) {
		if (pos == 0)
			return;

		int parentNode = getParent(pos);
		System.out.println(parentNode);
		System.out.println(pos);

		if (parentNode >= 0)
			if (numsStore.get(parentNode) > numsStore.get(pos)) {
				int papaNode = numsStore.get(parentNode);
				numsStore.add(papaNode, numsStore.get(pos));
				numsStore.add(pos, papaNode);
				heapify(parentNode);
			}

	}

	static int getLeftChild(int parent) {
		return 2 * parent + 1;
	}

	static int getRightChild(int parent) {
		return 2 * parent + 2;
	}

	static int getParent(int child) {
		return (child / 2) - 1;
	}

}
