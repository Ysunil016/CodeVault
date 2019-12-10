package LinkedList;

/**
 * @author sunil016
 */

/*
 * Given two sorted linked lists consisting of N and M nodes respectively. The
 * task is to merge both of the list (in-place) and return head of the merged
 * list.
 * 
 * Note: It is strongly recommended to do merging in-place using O(1) extra
 * space.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line of input contains N and M, and next two line contains N and M
 * sorted elements in two lines for each.
 * 
 * Output: For each testcase, print the merged list in sorted form.
 * 
 * User Task: The task is to complete the function sortedMerge() which takes
 * references to the heads of two linked lists as the arguments and returns the
 * head of merged linked list.
 * 
 * Constraints: 1 <= T <= 200 1 <= N, M <= 103 1 <= Node's data <= 103
 * 
 * Example: Input: 2 4 3 5 10 15 40 2 3 20 2 2 1 1 2 4
 * 
 * Output: 2 3 5 10 15 20 40 1 1 2 4
 * 
 * Explanation: Testcase 1: After merging the two linked lists, we have merged
 * list as 2, 3, 5, 10, 15, 20, 40.
 * 
 */
public class MergeTwoSortedLinkedList {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node rootOne = new Node(1);
		Node rootTwo = new Node(2);
		Node rootThree = new Node(9);
		Node rootFour = new Node(12);
		Node rootFive = new Node(15);
		Node headOne = new Node(7);
		Node headTwo = new Node(8);
		Node headThree = new Node(9);
		Node headFour = new Node(10);

		rootOne.next = rootTwo;
		rootTwo.next = rootThree;
		rootThree.next = rootFour;
		rootFour.next = rootFive;

		headOne.next = headTwo;
		headTwo.next = headThree;
		headThree.next = headFour;

//		printLinkedList(mergeLinkedList(rootOne, headOne));
		printLinkedList(mergeLinkedListRec(rootOne, headOne));

	}

	// Merging LinkedList
	public static Node mergeLinkedList(Node left, Node right) {
		Node head = new Node(-1);
		Node currentNode = head;
		while (left != null && right != null) {
			if (left.data < right.data) {
				currentNode.next = left;
				left = left.next;
			} else {
				currentNode.next = right;
				right = right.next;
			}
			currentNode = currentNode.next;
		}

		// If Still there is Current
		if (left != null)
			currentNode.next = left;

		if (right != null)
			currentNode.next = right;

		return head.next;
	}

	static void printLinkedList(Node node) {
		if (node == null)
			return;
		while (node != null) {
			System.out.print("-> " + node.data);
			node = node.next;
		}
	}

	// Recursion
	public static Node mergeLinkedListRec(Node left, Node right) {

		if (left == null)
			return right;

		if (right == null)
			return left;

		if (left.data < right.data) {
			left.next = mergeLinkedListRec(left.next, right);
			return left;
		} else {
			right.next = mergeLinkedListRec(left, right.next);
			return right;
		}

	}
}
