package data_structures.linkedlists;

public class InsertANodeAtTheHeadOfALinkedList {

	Node Insert(Node head, int x) {
		Node newHead = new Node();
		newHead.data = x;
		newHead.next = head;
		return newHead;
	}
}
