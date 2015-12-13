package data_structures.linkedlists;

public class CompareTwoLinkedLists {
	int CompareLists(Node headA, Node headB) {
		// This is a "method-only" submission.
		// You only need to complete this method
		return Cat(headA).equals(Cat(headB)) ? 1 : 0;

	}

	public String Cat(Node head) {
		if (head != null)
			return head.data + " --> " + Cat(head.next);
		return "null";
	}
}
