package data_structures.trees;

public class BinarySearchTreeInsertion {
	static Node Insert(Node root,int value)
	{

	   Node node = new Node();
	   node.data = value;
	    
	    if(root == null)
	        return node;
	    
	    if(root.data < value){
	        if(root.right == null){
	            root.right = node;
	        } else {
	            root.right = Insert(root.right, value);
	        }
	    } else if (root.data > value){
	        if(root.left == null){
	            root.left = node;
	        } else {
	            root.left = Insert(root.left, value);
	        }
	    }

	    return root;
	}
}
