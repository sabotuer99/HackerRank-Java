package data_structures.linkedlists;

public class DeleteANode {

	Node Delete(Node head, int position) {
		// Complete this method
		// System.out.println(Cat(head));
		// System.out.println(data);
		// System.out.println(position);

		if (head == null)
			return null;

		if (position == 0)
			return head.next;

		Node index = head;
		Node next = head.next;
		for (int i = 0; i < position - 1; i++) {
			index = next;
			if (index != null)
				next = index.next;
		}

		if (next != null)
			index.next = next.next;
		else
			index.next = null;

		return head;
	}

	public String Cat(Node head) {
		if (head != null)
			return head.data + " --> " + Cat(head.next);
		return "null";
	}
}
