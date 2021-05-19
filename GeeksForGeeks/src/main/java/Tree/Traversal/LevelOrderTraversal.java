package Tree.Traversal;

import java.util.LinkedList;
import java.util.Stack;

import Tree.TNode;

public class LevelOrderTraversal {

	public static void main(String[] args) {

		TNode rootNode = RandomTreeGeneration.getRandomTreeGeneration(new TNode(20), 4, 0);
		levelOrderTraversal_Left2Right(rootNode);
		System.out.println();
		levelOrderTraversal_Right2Left(rootNode);
		System.out.println();
		levelOrderTraversal_Left2Right_Bottom2Up(rootNode);
		System.out.println();
		levelOrderTraversal_Right2Left_Bottom2Up(rootNode);

	}

	// LevelOrder Traversal using Recursion
	public static void levelOrderTraversal_Left2Right(TNode root) {
		if (root == null)
			return;
		LinkedList<TNode> queue = new LinkedList<TNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TNode currentNode = queue.poll();
			System.out.print("-> " + currentNode.data);
			if (currentNode.left != null)
				queue.add(currentNode.left);
			if (currentNode.right != null)
				queue.add(currentNode.right);
		}

	}

	// LevelOrder Traversal using Recursion
	public static void levelOrderTraversal_Right2Left(TNode root) {
		if (root == null)
			return;
		LinkedList<TNode> queue = new LinkedList<TNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TNode currentNode = queue.poll();
			System.out.print("-> " + currentNode.data);
			if (currentNode.right != null)
				queue.add(currentNode.right);
			if (currentNode.left != null)
				queue.add(currentNode.left);
		}

	}

	// LevelOrder Traversal using Recursion
	public static void levelOrderTraversal_Left2Right_Bottom2Up(TNode root) {
		if (root == null)
			return;

		LinkedList<TNode> queue = new LinkedList<TNode>();
		Stack<TNode> stack = new Stack<TNode>();
		queue.add(root);
		stack.push(root);
		while (!queue.isEmpty()) {
			TNode currentNode = queue.poll();
			if (currentNode.right != null) {
				queue.add(currentNode.right);
				stack.push(currentNode.right);
			}
			if (currentNode.left != null) {
				queue.add(currentNode.left);
				stack.push(currentNode.left);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print("-> " + stack.pop().data);
		}

	}

	// LevelOrder Traversal using Recursion
	public static void levelOrderTraversal_Right2Left_Bottom2Up(TNode root) {
		if (root == null)
			return;

		LinkedList<TNode> queue = new LinkedList<TNode>();
		Stack<TNode> stack = new Stack<TNode>();
		queue.add(root);
		stack.push(root);
		while (!queue.isEmpty()) {
			TNode currentNode = queue.poll();
			if (currentNode.left != null) {
				queue.add(currentNode.left);
				stack.push(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
				stack.push(currentNode.right);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print("-> " + stack.pop().data);
		}

	}

}
