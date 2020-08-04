package LinkedList;

public class StackUsingLinkedList {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.pop();
		System.out.println(stack.peek());
		stack.push(50);
		stack.push(60);
		stack.pop();
		System.out.println(stack.peek());

	}

	static class Stack {

		Node head;
		Node startPoint;

		class Node {
			int val;
			Node next;

			public Node(int val) {
				this.val = val;
			}
		}

		public void display() {
			while (startPoint != null) {
				System.out.println(startPoint.val);
				startPoint = startPoint.next;
			}
		}

		public void push(int val) {
			if (head == null) {
				head = new Node(val);
				startPoint = head;
			} else {
				Node tN = startPoint;
				while (tN.next != null) {
					tN = tN.next;
				}
				tN.next = new Node(val);
			}
		}

		public void pop() {
			Node prevNode = null;
			Node tN = startPoint;
			if (startPoint == null) {
				return;
			}
			while (tN.next != null) {
				prevNode = tN;
				tN = tN.next;
			}
			if (prevNode != null)
				prevNode.next = null;
			else
				head = null;
		}

		public int peek() {
			Node tN = startPoint;
			if (tN == null)
				return -1;
			while (tN.next != null) {
				tN = tN.next;
			}
			return tN.val;

		}

	}

}
