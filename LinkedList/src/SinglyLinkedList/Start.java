package SinglyLinkedList;

public class Start {
	static Node head;
	static Node headOne;
	static Node headTwo;

	public static void main(String[] args) {

		// BasicOperations bOperation = new BasicOperations();
		AdvanceOperations aOperations = new AdvanceOperations();

		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		headOne = one;
		one.next = two;
		two.next = three;
		headTwo = four;
		four.next = five;
		five.next = six;
		six.next = seven;

		// Palindrome Input

//		Node one = new Node(1);
//		Node two = new Node(2);
//		Node three = new Node(3);
//		Node four = new Node(4);
//		Node five = new Node(3);
//		Node six = new Node(2);
//		Node seven = new Node(1);

		// LinkedList with Loop
//		{
//			head = one;
//			one.next = two;
//			two.next = three;
//			three.next = four;
//			four.next = five;
//			five.next = six;
//			six.next = seven;
//			seven.next = three;
//		}

//		Node loopNode = aOperations.hasLoop(head);
//		if (loopNode != null)
//			System.out.println("Intersecting Node is :: " + loopNode.data);

		// LinkedList for IntersectionNode
//		{
//		headOne = one;
//		one.next = four;
//		four.next = five;
//		five.next = six;
//		six.next = seven;
//
//		headTwo = two;
//		two.next = three;
//		three.next = five;
//		five.next = six;
//		six.next = seven;
//		}

//		System.out.println(aOperations.isLinkedListsIntersect(headOne, headTwo));
//		Node inNode = aOperations.intersectionNode(headOne, headTwo);
//		if (inNode != null)
//			System.out.println(inNode.data);

//		head = one;
//		one.next = two;
//		two.next = three;
//		three.next = four;
//		four.next = five;
//		five.next = six;
//		six.next = seven;
//		System.out.println(aOperations.isPalindrome(head));

		aOperations.mergingTwoSortedLinkedList(headOne, headTwo);

	}

}
