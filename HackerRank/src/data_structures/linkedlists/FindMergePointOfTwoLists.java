package data_structures.linkedlists;

public class FindMergePointOfTwoLists {
	int FindMergeNode(Node headA, Node headB) {
	    // Complete this function
	    // Do not write the main method. 
	    Node indexA = headA; 
	    Node indexB = headB; 
	    int data = 0;
	    boolean found = false;
	    while(indexA != null && !found){
	        indexB = headB;
	        indexA = indexA.next; 
	        
	        while(indexB != null){
	            if(indexB.equals(indexA)){
	                data = indexB.data;
	                found = true;
	            }
	                
	            indexB = indexB.next;           
	        }       
	    } 
	    
	    return data;
	}
}
