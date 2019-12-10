package LinkedList;

public class SortLinkedListUsingMergeSort {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node linkedList = getDummyLinkedList();
		printLinkedList(linkedList);
		System.out.println();
		System.out.println();
		System.out.println("Getting Sorted Linked List");
		printLinkedList(getSortedLinkedList(linkedList));
	}

	static Node getSortedLinkedList(Node head) {
		if (head == null || head.next == null)
			return head;

		Node slow = head;
		Node fast = head;
		Node prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		// UnBinding LinkedList
		prev.next = null;

		Node leftLink = getSortedLinkedList(head);
		Node rightLink = getSortedLinkedList(slow);

		return MERGE(leftLink, rightLink);
	}

	static Node MERGE(Node left, Node right) {
		Node newNode = new Node(-1);
		Node mergedNode = newNode;

		while (left != null && right != null) {
			if (left.data < right.data) {
				mergedNode.next = left;
				left = left.next;
			} else {
				mergedNode.next = right;
				right = right.next;
			}
			mergedNode = mergedNode.next;
		}

		if (left != null) {
			mergedNode.next = left;
		}
		if (right != null) {
			mergedNode.next = right;
		}

		return newNode.next;
	}

	static void printLinkedList(Node node) {
		if (node == null)
			return;
		while (node != null) {
			System.out.print("-> " + node.data);
			node = node.next;
		}
	}

	static Node getDummyLinkedList() {
		Node head = new Node((int) (Math.random() * 100));
		Node currentNode = head;
		for (int i = 0; i < 9; i++) {
			currentNode.next = new Node((int) (Math.random() * 100));
			currentNode = currentNode.next;
		}
		return head;
	}
}
