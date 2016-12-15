package algorithms.strings;

import java.math.BigInteger;
import java.util.Scanner;

public class TwoTwo {

    public static class Trie{
        
        private class Node{
            Node[] digits = new Node[10];
            boolean isTerminal = false;
            
            public void insert(char[] sequence, int index){
                if(index == sequence.length){
                    isTerminal = true;
                } else {
                    Node node = digits[sequence[index] - '0'];
                    node = node == null ? new Node() : node;
                    node.insert(sequence, index + 1);
                    digits[sequence[index] - '0'] = node;
                }
            }
            
            public int contains(char[] sequence, int index){
                if(index == sequence.length || digits[sequence[index] - '0'] == null){
                    return isTerminal ? 1 : 0;
                } else {
                    int term = isTerminal ? 1 : 0;
                    return term + digits[sequence[index] - '0'].contains(sequence, index + 1);
                }
            }
        }
        
        Node head = new Node();
        
        public void insert(String sequence){
            head.insert(sequence.toCharArray(), 0);
        }
        
        public int contains(char[] sequence, int index){
            return head.contains(sequence, index);
        }
    }
    
    
    
    public static void main(String[] args) {
        Trie twos = new Trie();
        BigInteger current = BigInteger.valueOf(1);
        BigInteger two = BigInteger.valueOf(2);
        for(int i = 0; i <= 800; i++){
            twos.insert(current.toString());
            current = current.multiply(two);
        }
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(; T > 0; T--){
            char[] s = in.next().toCharArray();
            int total = 0;
            for(int i = 0; i < s.length; i++){
                total += twos.contains(s, i);
            }
            
            System.out.println(total);
        }
        in.close();
    }
}
