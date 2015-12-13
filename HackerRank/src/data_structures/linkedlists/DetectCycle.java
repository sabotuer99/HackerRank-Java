package data_structures.linkedlists;

public class DetectCycle {
	int HasCycle(Node head) {
	    if(head == null)
	        return 0;
	    
	    Node tort = head;
	    Node hare = head.next;
	    
	    while(tort != null && hare != null && !tort.equals(hare)){
	        tort = tort.next;
	        hare = hare.next;
	        if(hare != null)
	            hare = hare.next;
	    }
	    
	    return tort == null || hare == null ? 0 : 1;
	}
}
