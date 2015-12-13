package data_structures.linkedlists;

public class InsertANodeAtASpecificPositionInALinkedList {
	Node InsertNth(Node head, int data, int position) {
		// System.out.println(Cat(head));
		// System.out.println(data);
		// System.out.println(position);

		if (head == null) {
			head = new Node();
			head.data = data;
		} else if (position == 0) {
			Node insNode = new Node();
			insNode.data = data;
			insNode.next = head;
			head = insNode;
		} else {
			Node index = head;
			for (int i = 0; i < position - 1; i++) {
				if (index != null)
					index = index.next;
			}
			Node insNode = new Node();
			insNode.data = data;

			if (index != null) {
				insNode.next = index.next;
				index.next = insNode;
			} else {
				index = insNode;
			}

		}

		return head;
	}

	public String Cat(Node head) {
		if (head != null)
			return head.data + " --> " + Cat(head.next);
		return "null";
	}
}
