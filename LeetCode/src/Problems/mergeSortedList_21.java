package Problems;

public class mergeSortedList_21 {

	class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	
	
	public Node mergeTwoLists(Node l1, Node l2) {
		Node rootNode = new Node(-1);
		Node currentNode = rootNode;
		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				currentNode.next = l1;
				l1 = l1.next;
			} else {
				currentNode.next = l2;
				l2 = l2.next;
			}
			currentNode = currentNode.next;
		}

		if (l1 != null) {
			currentNode.next = l1;
		}
		if (l2 != null) {
			currentNode.next = l2;
		}
		return rootNode.next;
	}
}
