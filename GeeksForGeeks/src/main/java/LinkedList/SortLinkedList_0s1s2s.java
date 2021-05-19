package LinkedList;

public class SortLinkedList_0s1s2s {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(0);
		Node one = head.next = new Node(2);
		Node two = one.next = new Node(1);
		Node three = two.next = new Node(1);
		Node four = three.next = new Node(2);
		Node five = four.next = new Node(0);
		five.next = new Node(1);

		head = segregate(head);
		printLinkedList(head);

	}

	static Node segregate(Node head) {
		Node result = new Node(-1);
		Node residue = head;

		Node resHolder = result;

		Node zeroPointer = new Node(-1);
		Node tempZero = zeroPointer;
		Node onePointer = new Node(-1);
		Node tempOne = onePointer;
		Node twoPointer = new Node(-1);
		Node tempTwo = twoPointer;

		while (residue != null) {
			if (residue.data == 0) {
				tempZero.next = new Node(residue.data);
				tempZero = tempZero.next;
			} else if (residue.data == 1) {
				tempOne.next = new Node(residue.data);
				tempOne = tempOne.next;
			} else if (residue.data == 2) {
				tempTwo.next = new Node(residue.data);
				tempTwo = tempTwo.next;
			}
			residue = residue.next;
		}

		resHolder.next = zeroPointer.next;
		while (resHolder.next != null)
			resHolder = resHolder.next;
		resHolder.next = onePointer.next;
		while (resHolder.next != null)
			resHolder = resHolder.next;
		resHolder.next = twoPointer.next;

		return result.next;
	}

	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print("-> " + head.data);
			head = head.next;
		}

	}

}
