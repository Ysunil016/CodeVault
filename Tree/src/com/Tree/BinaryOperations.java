package com.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryOperations {

	public void InOrderTraverse(Node root) {
		if (root == null)
			return;
		System.out.println(root.data + " ");
		InOrderTraverse(root.left);
		InOrderTraverse(root.right);
	}

	public void PreOrderTraverse(Node root) {
		if (root == null)
			return;
		PreOrderTraverse(root.left);
		System.out.println(root.data + " ");
		PreOrderTraverse(root.right);
	}

	public void PostOrderTraverse(Node root) {
		if (root == null)
			return;
		PostOrderTraverse(root.left);
		PostOrderTraverse(root.right);
		System.out.println(root.data + " ");
	}

	public void levelOrderTraversing(Node root) {
		Queue<Node> queueStore = new LinkedList<Node>();
		queueStore.add(root);
		while (!queueStore.isEmpty()) {
			Node tempNode = queueStore.poll();
			System.out.println(tempNode.data);
			if (tempNode.left != null) {
				queueStore.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queueStore.add(tempNode.right);
			}

		}
	}

	public int heightOfTree(Node root) {
		if (root == null)
			return 0;
		return (int) Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;

	}

	public void treeTopView(Node root) {
		treeTopViewLeft(root);
		treeTopViewRight(root.right);
	}

	public void treeTopViewLeft(Node root) {
		if (root == null)
			return;
		treeTopViewLeft(root.left);
		System.out.println(root.data);
	}

	public void treeTopViewRight(Node root) {
		if (root == null)
			return;
		System.out.println(root.data);
		treeTopViewRight(root.right);
	}

	public boolean isBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data > max || root.data < min)
			return false;
		if (isBST(root.left, min, root.data) && isBST(root.right, root.data, max))
			return true;
		else
			return false;
	}

	int temp = 0;

	public void verticalTraverse(Node root) {
		if (root == null) {
			return;
		}

		System.out.println(root.data + " at " + temp);
		temp--;
		verticalTraverse(root.left);
		temp++;
		verticalTraverse(root.right);
		temp++;
	}

}
