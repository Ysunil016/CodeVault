package LinkedList;

public class QueueUsingLinkedList {

	static class QueueNode {
		int data;
		QueueNode next;

		QueueNode(int a) {
			data = a;
			next = null;
		}
	}

	static QueueNode front, rear;

	public static void main(String[] args) {

		pop();
		push(60);
		push(70);
		push(80);
		pop();
		pop();
		printLinkedList(front);
	}

	static void printLinkedList(QueueNode head) {
		while (head != null) {
			System.out.print("-> " + head.data);
			head = head.next;
		}
	}

	static void push(int a) {
		if (rear == null) {
			rear = front = new QueueNode(a);
			return;
		}
		if (rear.equals(front)) {
			front.next = rear = new QueueNode(a);
			return;
		}
		rear.next = new QueueNode(a);
		rear = rear.next;

	}

	static int pop() {
		QueueNode currentNode = front;
		if (currentNode == null)
			return -1;

		if (currentNode == rear) {
			front = null;
			rear = null;
			return currentNode.data;
		}

		front = currentNode.next;
		return currentNode.data;
	}

}
