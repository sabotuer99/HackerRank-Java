package data_structures.linkedlists;

public class GetNodeValue {
	int GetNode(Node head, int n) {
		// This is a "method-only" submission.
		// You only need to complete this method.

		int length = 1;
		Node index = head;
		while (index.next != null) {
			length++;
			index = index.next;
		}

		int position = length - n;
		while (position > 1) {
			position--;
			head = head.next;
		}

		return head.data;
	}
}
