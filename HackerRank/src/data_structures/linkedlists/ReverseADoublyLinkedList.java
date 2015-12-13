package data_structures.linkedlists;

public class ReverseADoublyLinkedList {
	Node Reverse(Node head) {
		// empty or one element
		if (head == null || head.next == null)
			return head;

		Integer itercount = 0;
		Node rev = new Node();
		rev.data = head.data;
		head = head.next;

		while (head != null) {
			Node temp = new Node();
			temp.data = head.data;
			temp.prev = rev.prev;
			temp.next = rev;
			rev = temp;
			itercount += 1;
			// System.out.println("Iteration: " + itercount);
			// System.out.println(Cat(temp));
			// System.out.println(Cat(head));
			// System.out.println(Cat(rev));
			head = head.next;
		}
		return rev;

	}
}
