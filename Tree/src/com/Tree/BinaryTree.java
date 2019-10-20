package com.Tree;

public class BinaryTree {

	static Node root;

	public static void main(String args[]) {

		BinaryOperations bOps = new BinaryOperations();

		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node ten = new Node(10);
		Node eleven = new Node(11);
		Node twelve = new Node(12);
		Node thirteen = new Node(13);
		Node fourteen = new Node(14);
		Node fifteen = new Node(15);
		Node sixteen = new Node(16);
		Node seventeen = new Node(17);
		Node eighteen = new Node(18);
		Node ninteen = new Node(19);
		Node twenty = new Node(20);

		root = one;
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		five.left = six;
		six.left = seven;
		seven.left = eight;
		seven.right = nine;
		nine.left = ten;
		ten.left = eleven;
		eleven.left = twelve;

		// bOps.InOrderTraverse(root);
//		bOps.PreOrderTraverse(root);
		// bOps.PostOrderTraverse(root);
//		bOps.levelOrderTraversing(root);
//		bOps.heightOfTree(root);
//		System.out.println(bOps.maxHeight);

//		bOps.treeTopView(root);

//		System.out.println(bOps.heightOfTree(root) - 1);
//		System.out.println(bOps.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		bOps.verticalTraverse(root);
	}

}
