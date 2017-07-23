package algorithms.implementation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BirthdayChocolate {

    static int solve(int n, int[] s, int d, int m){
        Deque<Integer> queue = new ArrayDeque<>();
        int matches = 0;
        int runningTotal = 0;
        
        
        for(int i = 0; i < s.length; i++){
            runningTotal += s[i];
            queue.offer(s[i]);
            //System.out.println("Pushed: " + s[i] + "  Total: " + runningTotal + "  Queue size: " + queue.size());
            if(queue.size() > m){
                int pop = queue.poll();
                runningTotal -= pop;
                //System.out.println("Popped: " + pop + "  Total: " + runningTotal + "  Queue size: " + queue.size());
            }
            if(queue.size() == m && runningTotal == d){
                //System.out.println("Matched! Total: " + runningTotal + "  Queue size: " + queue.size());
                matches += 1;
            }
        }
        
        return matches;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
        in.close();
    }
}
