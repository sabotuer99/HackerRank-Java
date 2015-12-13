package data_structures.linkedlists;

public class PrintTheElementsOfALinkedList {

	void Print(Node head) {
		if (head != null) {
			System.out.println(head.data);
			Print(head.next);
		}
	}
}
