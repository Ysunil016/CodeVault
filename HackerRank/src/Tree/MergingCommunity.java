package Tree;

import java.util.Scanner;

public class MergingCommunity {

	static Scanner scan = new Scanner(System.in);

	static class Node {
		int counter = 1;
		Node parent = null;

		void increment(int x) {
			this.counter = counter + x;
		}

	}

	public static void main(String[] args) {
		int individuals = scan.nextInt();
		Node[] indArray = new Node[individuals + 1];
		for (int i = 0; i <= individuals; i++)
			indArray[i] = new Node();

		int queries = scan.nextInt();
		for (int i = 0; i < queries; i++) {
			char sCase = scan.next().charAt(0);
			switch (sCase) {
			case 'M':
				int x = scan.nextInt();
				int y = scan.nextInt();
				System.out.println(x + " and " + y);
				mergeInd(indArray, x, y);
				break;
			case 'Q':
				int node = scan.nextInt();
				System.out.println(rootNode(indArray[node]).counter);
				break;
			}
		}
	}

	// Making Concept in N-ary Tree
	static void mergeInd(Node[] arr, int x, int y) {
		Node parentX = rootNode(arr[x]);
		Node parentY = rootNode(arr[y]);

		if (parentX == parentY)
			return;

		parentY.parent = parentX;
		parentX.increment(parentY.counter);
	}

	static Node rootNode(Node x) {
		while (x.parent != null)
			x = x.parent;

		return x;
	}

}
