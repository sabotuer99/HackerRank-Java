package data_structures.trees;

import java.util.ArrayList;
import java.util.List;

public class TreeLevelOrderTraversal {
	
	void LevelOrder(Node root)
	{
	      List<Node> nextLevel = new ArrayList<Node>();
	      nextLevel.add(root);
	      print_level(nextLevel);
	}

	void print_level(List<Node> root){
	    List<Node> nextLevel = new ArrayList<Node>();
	    for(Node node : root){
	        if(node != null) {
	            System.out.print(node.data + " ");
	            nextLevel.add(node.left);
	            nextLevel.add(node.right);
	        }            
	    } 
	    
	    if (nextLevel.size() > 0)
	        print_level(nextLevel);
	}
}
