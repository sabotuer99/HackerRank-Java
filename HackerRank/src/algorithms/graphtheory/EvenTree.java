package algorithms.graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EvenTree {

    static class Node{
        int id;
        int size;
        Node parent;        
        List<Node> children;
        
        public Node(int id){
            this.id = id;
            this.size = 1;
            this.children = new ArrayList<Node>();
        }
        
        public void addChild(Node child){
            child.parent = this;
            children.add(child);
            incrementSize(child.size);
        }
        
        public void incrementSize(int val){
            this.size += val;
            if(parent != null){
                parent.incrementSize(val);
            }
        }
        
        public int evenSubTrees(){
            
            if(children.size() == 0)
                return 0;
            
            int evens = 0;
            
            for(Node child : children){
                if((child.size & 1) == 0) //child is even size
                    evens += 1;
                evens += child.evenSubTrees();
            }
            
            //System.out.println("Node " + id + ", size " + size + ", has " + evens + " even subTrees");
            
            return evens;
        }
        
        public Node root(){
            if(parent == null)
                return this;
            else 
                return parent.root();
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        
        Map<Integer, Node> nodes = new HashMap<Integer, Node>();
        Node root = new Node(0);
        
        for(int i = 0; i < M; i++){
            int id = in.nextInt();
            int pid = in.nextInt();
            
            Node node = nodes.get(id);
            if(node == null){
                node = new Node(id);
                nodes.put(id, node);
            }
                       
            Node parent = nodes.get(pid);
            if(parent == null){
                parent = new Node(pid);
                nodes.put(pid, parent);
            }
                
            parent.addChild(node);
            root = parent.root();
        }
        
        //System.out.println(root.id);
        //System.out.println(nodes.size());

        System.out.println(root.evenSubTrees());
    }
}
