package data_structures.linkedlists;

public class InsertANodeIntoASortedDoublyLinkedList {
	Node SortedInsert(Node head,int data) {
	    //System.out.println(data);
	    
	    
	    
	    Node node = new Node();
	    node.data = data;
	    
	    if(head == null)
	        return node;
	    
	    //System.out.println(data);
	    //System.out.println(Cat(head));
	    

	    if(data < head.data){
	        node.prev = head.prev;
	        node.next = head;
	        head.prev = node;
	        head = head.prev;
	    } else {
	        head.next = SortedInsert(head.next, data);
	    }
	    
	    //System.out.println(Cat(head));
	    
	    //System.out.println(Cat(index));
	    //System.out.println(Cat(node));
	    
	    return head;
	}

	public String Cat(Node head){
	    if(head != null)
	        return head.data + " --> " + Cat(head.next);
	    return "null";
	}
}
