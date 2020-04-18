package Tree;

import java.util.Scanner;

public class PreTreeConstruct {

	static Scanner scan = new Scanner(System.in);

	static class Node {
		int data;
		Node left = null;
//		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int nCount = scan.nextInt();
		int[] nodes = new int[nCount];
		char[] nodeType = new char[nCount];
		for (int i = 0; i < nCount; i++) {
			nodes[i] = scan.nextInt();
		}
		for (int i = 0; i < nCount; i++) {
			nodeType[i] = scan.next().charAt(0);
		}

		Node root = new Node(nodes[0]);
		preConstruct(root, nodes, nodeType, 0);
		printInorder(root);
	}

	static void preConstruct(Node root, int[] nodes, char[] nodeType, int index) {

		if (root == null)
			return;

//		System.out.println("Inside " + root.data);

		if (index + 1 == nodes.length)
			return;

		if (root.left == null && nodeType[index] != 'L') {
			System.out.println("Assigning Left " + nodes[index + 1] + " to " + root.data);
			root.left = new Node(nodes[index + 1]);
//			preConstruct(root.left, nodes, nodeType, index + 1);
		} else if (root.right == null && nodeType[index] != 'L') {
			System.out.println("Assigning Right " + nodes[index + 1] + " to " + root.data);
			root.right = new Node(nodes[index + 1]);
//			preConstruct(root.right, nodes, nodeType, index + 1);
		}

		preConstruct(root.left, nodes, nodeType, index + 1);

		preConstruct(root.right, nodes, nodeType, index + 1);

		if (index > 1)
			return;

		index = nodes.length - index;
		System.out.println(index);

		if (root.right == null) {
			System.out.println("Assigning Right " + nodes[index] + " to " + root.data);
			root.right = new Node(nodes[index]);
		} else if (root.left == null) {
			System.out.println("Assigning Left " + nodes[index] + " to " + root.data);
			root.left = new Node(nodes[index]);
		}

//		System.out.println(root.data);

	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print("-> " + root.data);
		printInorder(root.right);

	}

}
