package algorithms.dp;

import java.util.Scanner;

public class BricksGame {

    public static void main(String[] args) {
/*  
adapted from http://www.cnblogs.com/boring09/p/4483376.html
 */       
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(; t > 0; t--){
            int N = in.nextInt();
            long[] bricks = new long[N];  //brick scores
            long[] sum = new long[N];     //suffix sum array
            long[] best = new long[N];    //bottom up dp array
            
            int last = N-1;
            
            for(int i = 0; i < N; i++){
                bricks[i] = in.nextLong();
            }
            
            sum[last] = bricks[last];   // suffix sum of last element is last brick
            for(int i = last - 1; i >= 0; i--){
                sum[i] = bricks[i] + sum[i+1];  //sum of all bricks from end to i
            }
            
            best[last] = sum[last];             // best move for last three positions is to take
            best[last - 1] = sum[last - 1];     // all remaining bricks, which is the sum from
            best[last - 2] = sum[last - 2];     // that position to the end, i.e. sum[i]
            
            for(int i = last - 3; i >= 0; i--){
                for(int j = 1; j <= 3; j++){
                    //System.out.println(i + " " + j + " " + best[i] + " " + (sum[i] - best[i + j]));
                    //the best move from this position is the
                    //sum of all the bricks from the end to this position
                    //minus the best move your opponent can make i.e.
                    //best[this position + bricks taken]
                    //pretty straight forward DP when you wrap your head around the problem...
                    best[i] = Math.max(best[i], sum[i] - best[i + j]);                        
                }
            }
            
            System.out.println(best[0]);
        }
    }
}
