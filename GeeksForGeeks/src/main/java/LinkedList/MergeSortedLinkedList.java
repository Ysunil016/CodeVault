package LinkedList;

public class MergeSortedLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node one = new Node(10);
		Node two = one.next = new Node(20);
		Node three = two.next = new Node(30);
		three.next = new Node(40);
		Node one2 = new Node(12);
		Node two2 = one2.next = new Node(24);
		Node three2 = two2.next = new Node(36);
		three2.next = new Node(48);

		Node result = getMergedList(one, one2);

		printLinkedList(result);
	}

	static Node getMergedList(Node headA, Node headB) {
		Node finalNode = new Node(-1);
		Node result = finalNode;
		while (headA != null && headB != null) {
			if (headA.data <= headB.data) {
				result.next = headA;
				headA = headA.next;
			} else {
				result.next = headB;
				headB = headB.next;
			}
			result = result.next;
		}

		if (headA != null)
			result.next = headA;

		if (headB != null)
			result.next = headB;

		return finalNode.next;
	}

	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print("-> " + head.data);
			head = head.next;
		}
	}

	static Node getRandomLinkedList(int counter) {
		Node head = new Node(69);
		Node currentNode = head;
		for (int i = 0; i < counter; i++) {
			currentNode.next = new Node((int) (Math.random() * 100));
			currentNode = currentNode.next;
		}
		return head;
	}

}
