package May.WeekThree;

public class OddEvenLinkedList {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
//		head.next.next.next.next.next = new Node(4);
//		head.next.next.next.next.next.next = new Node(7);

//		displayNode(head);
		jumbleList(head);

	}

	static Node jumbleList(Node head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;
		Node currentNode = head;
		Node odd = new Node(-1);
		Node even = new Node(-1);
		Node oddC = odd;
		Node evenC = even;

		while (currentNode != null) {
			oddC.next = currentNode;
			oddC = oddC.next;
			if (currentNode.next != null) {
				evenC.next = currentNode.next;
				evenC = evenC.next;
			} else {
				evenC.next = null;		
				break;
			}
			currentNode = currentNode.next.next;
		}

		oddC.next = even.next;
		return (odd.next);
	}

	static void displayNode(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
	}

}
