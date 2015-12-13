package data_structures.trees;

public class TreeInorderTraversal {
	void Inorder(Node root) {
	    if(root != null){
	        
	        Inorder(root.left);
	        System.out.print(root.data + " ");
	        Inorder(root.right);
	        
	    }  
	}
}
