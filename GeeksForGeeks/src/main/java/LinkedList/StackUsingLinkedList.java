package LinkedList;

public class StackUsingLinkedList {

	static class StackNode {
		int data;
		StackNode next;

		StackNode(int a) {
			data = a;
			next = null;
		}
	}

	static StackNode top;

	public static void main(String[] args) {

//		top = head;
		push(78);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		push(93);
		System.out.println(pop());
		System.out.println(pop());
		push(28);
		push(60);
		System.out.println(pop());
		push(41);
		push(73);

		printLinkedList(top);
	}

	static void printLinkedList(StackNode head) {
		if (head == null)
			System.out.println("NULL");
		while (head != null) {
			System.out.print("-> " + head.data);
			head = head.next;
		}

	}

	static void push(int a) {
		StackNode currentNode = top;
		if (currentNode == null) {
			top = new StackNode(a);
			return;
		}
		if (currentNode.next == null) {
			currentNode.next = new StackNode(a);
			return;
		}
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = new StackNode(a);
	}

	static int pop() {
		StackNode currentNode = top;
		StackNode prev = null;

		if (currentNode == null)
			return -1;

		if (currentNode.next == null) {
			top = null;
			return currentNode.data;
		}

		while (currentNode.next != null) {
			prev = currentNode;
			currentNode = currentNode.next;
		}
		prev.next = null;
		return currentNode.data;
	}

}
