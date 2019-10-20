package SinglyLinkedList;

import java.util.Stack;

public class AdvanceOperations {

	public Node hasLoop(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				break;
			}
		}
		slowPointer = head;
		while ((slowPointer != fastPointer)) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
			if (fastPointer == null)
				return fastPointer;
		}

		return fastPointer;
	}

	public boolean isLinkedListsIntersect(Node head1, Node head2) {
		Node currentNodeOne = head1;
		Node currentNodeTwo = head2;

		while (currentNodeOne.next != null) {
			currentNodeOne = currentNodeOne.next;
		}
		while (currentNodeTwo.next != null) {
			currentNodeTwo = currentNodeTwo.next;
		}

		if (currentNodeOne == currentNodeTwo) {
			return true;
		}

		return false;
	}

	public Node intersectionNode(Node head1, Node head2) {
		Node currentNodeOne = head1;
		Node currentNodeTwo = head2;
		int lengthOne = 0;
		int lengthTwo = 0;

		while (currentNodeOne.next != null) {
			lengthOne++;
			currentNodeOne = currentNodeOne.next;
		}
		while (currentNodeTwo.next != null) {
			lengthTwo++;
			currentNodeTwo = currentNodeTwo.next;
		}

		currentNodeOne = head1;
		currentNodeTwo = head2;

		if (lengthOne > lengthTwo) {
			int absDef = lengthOne - lengthTwo;
			for (int i = 0; i < absDef; i++)
				currentNodeOne = currentNodeOne.next;
		}
		if (lengthOne < lengthTwo) {
			int absDef = lengthTwo - lengthOne;
			for (int i = 0; i < absDef; i++)
				currentNodeTwo = currentNodeTwo.next;
		}

		while (currentNodeOne != null) {
			currentNodeOne = currentNodeOne.next;
			currentNodeTwo = currentNodeTwo.next;

			if (currentNodeOne == currentNodeTwo) {
				return currentNodeOne;
			}
		}

		return null;
	}

	public boolean isPalindrome(Node head) {
		Stack<Integer> tempStack = new Stack<Integer>();
		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer.next != null) {
			tempStack.push(slowPointer.data);
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		if (fastPointer != null)
			slowPointer = slowPointer.next;

		while (slowPointer != null) {
			if (tempStack.pop() != slowPointer.data) {
				return false;
			}
		}

		return true;
	}

	public Node mergingTwoSortedLinkedList(Node head1, Node head2) {
		Node resNode = head1;
		Node currentNodeOne = head1;
		Node currentNodeTwo = head2;

		BasicOperations bOperation = new BasicOperations();

//		System.out.print(currentNodeOne.data + " ");
//		System.out.print(currentNodeTwo.data + " ");
//		System.out.println();

		if (currentNodeOne.data < currentNodeTwo.data) {
			resNode = currentNodeOne;
			resNode = resNode.next;
			currentNodeOne = currentNodeOne.next;
		} else {
			resNode = currentNodeTwo;
			resNode = resNode.next;
			currentNodeTwo = currentNodeTwo.next;
		}

		while (currentNodeOne != null && currentNodeTwo != null) {
			System.out.println(resNode.data);
			if (currentNodeOne.data < currentNodeTwo.data) {
				resNode = currentNodeOne;
				resNode = resNode.next;
				currentNodeOne = currentNodeOne.next;
			} else {
				resNode = currentNodeTwo;
				resNode = resNode.next;
				currentNodeTwo = currentNodeTwo.next;
			}
		}
		bOperation.displayLinkedList(resNode);

		while (currentNodeOne != null) {
			resNode = currentNodeOne;
			resNode = resNode.next;
			currentNodeOne = currentNodeOne.next;
		}
		while (currentNodeTwo != null) {
			resNode = currentNodeTwo;
			resNode = resNode.next;
			currentNodeTwo = currentNodeTwo.next;
		}

		bOperation.displayLinkedList(resNode);
		return resNode;
	}

}
