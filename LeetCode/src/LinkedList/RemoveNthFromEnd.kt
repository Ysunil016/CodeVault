package LinkedList

class ListNode {
	var data: Int = 0;
	var next: ListNode? = null;

	constructor (data: Int) {
		this.data = data;
	}
}

fun main(args: Array<String>) {
	var root: ListNode = ListNode(1);
	var one: ListNode = ListNode(2);
	var two: ListNode = ListNode(3);
	var three: ListNode = ListNode(4);
	var four: ListNode = ListNode(5);

	root.next = one;
	one.next = two;
	two.next = three;
	three.next = four;

	displayList(root);
	var result: ListNode? = removeNodeFromEnd(root, 5);
	println();
	displayList(result);
}

fun removeNodeFromEnd(head: ListNode?, n: Int): ListNode? {
	var currentNode = head;
	if (head == null) return head;
	var slow: ListNode? = head;
	var fast: ListNode? = head;
	var counter: Int = 1;
	var prev: ListNode? = null;

	while (currentNode != null) {
		if (counter > n) {
			prev = slow;
			slow = slow?.next;
		}
		fast = fast?.next;
		counter++;
		currentNode = currentNode.next;
	}

	prev?.next = slow?.next;

	if (head == slow) {
		return head.next;
	}

	return head;
}


fun displayList(node: ListNode?) {
	var currentNode: ListNode? = node;
	while (currentNode != null) {
		print("-> ${currentNode.data}")
		currentNode = currentNode.next;
	}
}


