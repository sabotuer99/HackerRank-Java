package data_structures.linkedlists;

public class MergeTwoSortedLinkedLists {
	Node MergeLists(Node headA, Node headB) {
		// This is a "method-only" submission.
		// You only need to complete this method
		if (headA == null)
			return headB;
		if (headB == null)
			return headA;

		Node sorted = new Node();
		if (headA.data < headB.data) {
			sorted.data = headA.data;
			sorted.next = MergeLists(headA.next, headB);
		} else {
			sorted.data = headB.data;
			sorted.next = MergeLists(headA, headB.next);
		}

		return sorted;

	}
}
