import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Ksize = in.nextInt();
        int[] K = new int[Ksize];
        for(int i = 0; i < Ksize; i++){
            K[i] = in.nextInt();
        }
        
        Arrays.sort(K);
        
        if(!isPossible(N)){
            System.out.println(-1); 
            return;
        }
        
        Deque<State> queue = new ArrayDeque<>();
        
        for(int i = 0; i < K.length; i++){
            State init = new State(K, i, K[i], null);        
            queue.offer(init);
        }
               
        int depth = 0;
        while(queue.size() > 0){
            
            State state = queue.poll();
            for(int ki = state.ki; ki < K.length; ki++){
                if(ki >= 0 && K[ki] > 1){
                    State next = new State(K, ki, state.total * K[ki], state);                      
                    if(next.total == N){
                        System.out.println(next);
                        return;
                    }
                    
                    if(next.total < N){
                        queue.offer(next);
                    }                   
                }                                     
            }          
        }
        
        System.out.println(-1);             
    }

    static boolean isPossible(int N){
    
        int total = N;
        
        for(int i = 2; i <= 20; i++){          
            while((total/i) * i == total){
                total /= i;
            }                
        }
        
        return total == 1;
    }
     
    static class State{
        public int[] K;
        public int ki;
        public int total;
        public State prev;
        public int size;
        
        public State(int[] K, int ki, int total, State prev){
            this.K = K;
            this.ki = ki;
            this.total = total;
            this.prev = prev;
            
            if(prev == null){
                size = 1;
            } else {
                size = prev.size + 1;
            }
        }
        
        @Override
        public String toString(){            
            if(prev == null){
                if(ki == -1){
                    return "1";
                } else {
                    return "1 " + String.valueOf(total);
                }
                                  
            } else {
                return prev.toString() + " " + String.valueOf(total);
            }                       
        }     
    }
    
    
}
