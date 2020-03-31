package Ignite;

public class MirrorTree {

	static class Node {
		char data;
		Node left = null;
		Node right = null;

		Node(char data) {
			this.data = data;
		}
	}

	static boolean isTreeMirror = true;

	public static void main(String[] args) {
//		Node root1 = new Node('A');
//		root1.left = new Node('B');
//		root1.right = new Node('C');
//		root1.left.left = new Node('D');
//		root1.left.right = new Node('E');
//		root1.right.left = new Node('F');
//		root1.right.right = new Node('G');
//		root1.right.left.left = new Node('H');
//
//		Node root2 = new Node('A');
//		root2.left = new Node('C');
//		root2.right = new Node('B');
//		root2.left.left = new Node('G');
//		root2.left.right = new Node('F');
//		root2.right.left = new Node('D');
//		root2.right.right = new Node('E');
//		root2.left.right.right = new Node('H');

		Node root1 = new Node('1');
		root1.left = new Node('2');
		root1.left.left = new Node('3');
		root1.left.right = new Node('4');

		Node root2 = new Node('1');
		root2.right = new Node('2');
		root2.right.left = new Node('4');
		root2.right.right = new Node('3');

		mirrorTree(root1, root2);
		System.out.println("Given Trees are Mirror of Each Other ::::" + isTreeMirror);
	}

	// Function Sets Value of IsMirrorTree to False, If Any Rule is Violated
	static void mirrorTree(Node root1, Node root2) {

		// Condition at which After Leaf is Meet
		if (root1 == null && root2 == null) {
			return;
		}

		// Checking if for Some Node root1 has value and root2 does'nt have
		if (root1 != null && root2 == null) {
			isTreeMirror = false;
			return;
		}

		// Checking if for Some Node root1 has value and root2 does'nt have
		if (root2 != null && root1 == null) {
			isTreeMirror = false;
			return;
		}

		// Recursively Passing left of root1 and right of root2
		if (root1.data == root2.data) {
			// Passing Left of Tree 1 and Right of Tree 2
			mirrorTree(root1.left, root2.right);
			// Passing Right of Tree 1 and Left of Tree 2
			mirrorTree(root1.right, root2.left);
		} else {
			isTreeMirror = false;
			return;
		}
	}

}
