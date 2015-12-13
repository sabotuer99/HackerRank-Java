package data_structures.linkedlists;

public class DeleteDuplicateValueNodesFromSortedList {
	Node RemoveDuplicates(Node head) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		if (head == null || head.next == null)
			return head;

		Node index = head;
		while (index != null && index.next != null) {
			while (index.next != null && index.data == index.next.data) {
				index.next = index.next.next;
			}
			index = index.next;
		}
		return head;

	}
}
