package algorithms.graphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthAncestor {

    public static class Node{
        Integer id;
        Node parent = null;
        Node a5 = null;
        Node a10 = null;
        Node a50 = null;
        Node a100 = null;
        Node a500 = null;
        Node a1000 = null;
        Node a5000 = null;
        Node a10000 = null;
        Node a50000 = null;
        int height = 0;
        List<Node> children = new ArrayList<Node>();
        
        public Node(Integer id){
            this.id = id;
        }
        
        public void addChild(Node child){
            children.add(child);
            child.parent = this;
            child.height = this.height + 1;
            if(child.height > 5){
                child.a5 = this.parent.parent.parent.parent;
            } else return;
            if(child.height > 10){
                child.a10 = child.a5.parent.parent.parent.parent.parent;
            } else return;
            if(child.height > 50){
                child.a50 = child.a10.a10.a10.a10.a10;
            } else return;
            if(child.height > 100){
                child.a100 = child.a50.a10.a10.a10.a10.a10;
            } else return;
            if(child.height > 500){
                child.a500 = child.a100.a100.a100.a100.a100;
            } else return;
            if(child.height > 1000){
                child.a1000 = child.a500.a100.a100.a100.a100.a100;
            } else return;
            if(child.height > 5000){
                child.a5000 = child.a1000.a1000.a1000.a1000.a1000;
            } else return;
            if(child.height > 10000){
                child.a10000 = child.a5000.a1000.a1000.a1000.a1000.a1000;
            } else return;
            if(child.height > 50000){
                child.a50000 = child.a10000.a10000.a10000.a10000.a10000;
            }
        }
        
        public void remove(){            
            parent.children.remove(this);
        }
    }
    
    public static void insert(Node[] index, Integer Y, Integer X){

        Node YN = index[Y];
        
        if(YN == null)
            return;        
        
        Node XN = new Node(X);
        YN.addChild(XN);
        index[Y] = YN;
        index[X] = XN;
    }
    
    public static void remove(Node[] index, Integer Y){
        Node YN = index[Y];
        
        if(YN == null)
            return;
        
        YN.remove();
        index[Y] = null;
    }
    
    public static int kth(Node[] index, Integer X, Integer K){
        Node XN = index[X];
        
        if(XN == null)
            return 0;
        
        if(XN.height < K)
            return 0;
        
        Node ancestor = XN.parent;
        for(int i = K - 1; i > 0 && ancestor != null; i--){
            if(i > 50000){
                ancestor = ancestor.a50000;
                i -= 49999;
                continue;
            } else if(i > 10000){
                ancestor = ancestor.a10000;
                i -= 9999;
                continue;
            } else if(i > 5000){
                ancestor = ancestor.a5000;
                i -= 4999;
                continue;
            } else if(i > 1000){
                ancestor = ancestor.a1000;
                i -= 999;
                continue;
            } else if(i > 500){
                ancestor = ancestor.a500;
                i -= 499;
                continue;
            } else if (i > 100){
                ancestor = ancestor.a100;
                i -= 99;
                continue;
            } else if(i > 50){
                ancestor = ancestor.a50;
                i -= 49;
                continue;
            } else if (i > 10){
                ancestor = ancestor.a10;
                i -= 9;
                continue;
            } else if(i > 5){
                ancestor = ancestor.a5;
                i -= 4;
                continue;
            } else
                ancestor = ancestor.parent;
        }
        
        if(ancestor == null)
            return 0;
        else 
            return ancestor.id;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(; T > 0; T--){
            int P = in.nextInt();
            Node[] index = new Node[100001];
            Integer root = in.nextInt();
            Integer zero = in.nextInt();
            index[root] = new Node(root);
            
            for(int i = 0; i < P - 1; i++){
                Integer X = in.nextInt();
                Integer Y = in.nextInt();                
                insert(index, Y, X);
            }
            
            int Q = in.nextInt();
            StringBuilder sb = new StringBuilder();
            for(; Q > 0 ; Q--){
                int type = in.nextInt();
                switch(type){
                    case 0:
                        Integer Y0 = in.nextInt();
                        Integer X0 = in.nextInt();
                        insert(index, Y0, X0);
                        break;
                    case 1:
                        Integer X1 = in.nextInt();
                        remove(index, X1);
                        break;
                    case 2:
                        Integer X2 = in.nextInt();
                        Integer K = in.nextInt();
                        sb.append(kth(index, X2, K));
                        sb.append("\n");
                    break;
                }
            }
            System.out.print(sb.toString());
        }
    }
}
