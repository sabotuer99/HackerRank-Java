package data_structures.linkedlists;

public class InsertANodeAtTheTailOfALinkedList {

	Node Insert(Node head, int data) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		if (head == null) {
			head = new Node();
			head.data = data;
		} else {
			head.next = Insert(head.next, data);
		}
		return head;
	}
}
