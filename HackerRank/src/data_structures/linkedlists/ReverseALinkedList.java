package data_structures.linkedlists;

public class ReverseALinkedList {
	Node Reverse(Node head) {
		// empty or one element
		if (head == null || head.next == null)
			return head;

		Integer itercount = 0;
		Node rev = null;

		while (head != null) {
			Node temp = new Node();
			temp.data = head.data;
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

	public String Cat(Node head) {
		if (head != null)
			return head.data + " --> " + Cat(head.next);
		return "null";
	}
}
