package LinkedList;

public class AddingTwoNumbersInLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node head1 = new Node(5);
		head1.next = new Node(4);
//		Node two = one.next = new Node(2);
//		two.next = new Node(1);

		Node head2 = new Node(5);
		Node one1 = head2.next = new Node(4);
		one1.next = new Node(3);
//		two1.next = new Node(1);

		Node result = addingLinkedList(head1, head2);
		printLinkedList(result);

	}

	static Node addingLinkedList(Node head1, Node head2) {
		Node fRes = new Node(-1);
		Node result = fRes;
		int carry = 0;
		while (head1 != null && head2 != null) {
			int sum = carry + head1.data + head2.data;
			carry = 0;
			if (sum > 9) {
				carry = sum / 10;
				result.next = new Node((sum % 10));
			} else {
				result.next = new Node(sum);
			}
			result = result.next;
			head1 = head1.next;
			head2 = head2.next;
		}

		while (head1 != null) {
			int sum = carry + head1.data;
			carry = 0;
			if (sum > 9) {
				carry = sum / 10;
				result.next = new Node(sum % 10);
			} else {
				result.next = new Node(sum);
			}
			result = result.next;
			head1 = head1.next;
		}

		while (head2 != null) {
			int sum = carry + head2.data;
			carry = 0;
			if (sum > 9) {
				carry = sum / 10;
				result.next = new Node(sum % 10);
			} else {
				result.next = new Node(sum);
			}
			result = result.next;
			head2 = head2.next;

		}

		if (carry != 0)
			result.next = new Node(carry);

		return fRes.next;
	}

	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print("-> " + head.data);
			head = head.next;
		}
	}

}
