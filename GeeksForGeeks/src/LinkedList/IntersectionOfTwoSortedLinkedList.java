package LinkedList;

import java.util.Scanner;

public class IntersectionOfTwoSortedLinkedList {

	static Scanner scan = new Scanner(System.in);

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head1 = new Node(10);
		Node two = head1.next = new Node(20);
		Node three = two.next = new Node(40);
		Node four = three.next = new Node(50);

		Node head2 = new Node(15);
		Node two2 = head2.next = new Node(40);

		findIntersect(head1, head2);

	}

	static void findIntersect(Node head1, Node head2) {

		while (head1 != null && head2 != null) {
			if (head1.data == head2.data) {
				System.out.println(head1.data);
				head1 = head1.next;
				head2 = head2.next;
			} else {
				if (head1.data < head2.data)
					head1 = head1.next;
				else
					head2 = head2.next;
			}
		}
	}

}
