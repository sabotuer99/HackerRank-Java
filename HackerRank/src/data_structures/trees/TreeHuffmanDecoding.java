package data_structures.trees;

public class TreeHuffmanDecoding {

	void decode(String S ,Node root)
	{
	    while(S.length() > 0){
	        S = popData(S, root);
	    }
	}

	String popData(String S ,Node root){

	    if(root.right == null && root.left == null){
	        System.out.print(root.data);
	        return S;
	    } else {    
	        char c = S.charAt(0);
	        S = S.substring(1);
	        //System.out.println(c + "|" + S);
	        if(c == '0'){
	            return popData(S, root.left);
	        } else {
	            return popData(S, root.right);
	        }
	    }
	}
}
