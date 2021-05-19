package Tree;

import java.util.Scanner;

public class PreOrder2PostOrder_BST {

	static class BST_Node {
		int data;
		BST_Node left = null;
		BST_Node right = null;

		public BST_Node(int data) {
			this.data = data;
		}
	}

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tC = scan.nextInt();

		for (int i = 0; i < tC; i++) {
			BST_Node root = null;
			int size = scan.nextInt();
			for (int j = 0; j < size; j++) {
				int val = scan.nextInt();
				if (root == null)
					root = new BST_Node(val);
				else
					makeBST(root, val);
			}
			printPostOrder(root);
		}

	}

	static void printPostOrder(BST_Node root) {
		if (root == null)
			return;
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.data + " ");
	}

	static void makeBST(BST_Node root, int data) {
		if (root == null) {
			root = new BST_Node(data);
			return;
		}
		if (data < root.data) {
			if (root.left != null) {
				makeBST(root.left, data);
			} else {
				root.left = new BST_Node(data);
				return;
			}
		} else {
			if (root.right != null) {
				makeBST(root.right, data);
			} else {
				root.right = new BST_Node(data);
				return;
			}
		}

	}

}
