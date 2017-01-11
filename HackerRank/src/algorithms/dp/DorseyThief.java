package algorithms.dp;

import java.util.Scanner;

public class DorseyThief {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int W = in.nextInt();
        long[] DP = new long[W + 1];
        for(; N > 0; N--){
            int v = in.nextInt();
            int w = in.nextInt();
            
            for(int i = W; i >= w; i--){
                if(DP[i-w] != 0 || i == w){
                    DP[i] = Math.max(DP[i], DP[i-w] + v);
                }
            }
        }
        in.close();
        if(DP[W] == 0){
            System.out.println("Got caught!");
        } else {
            System.out.println(DP[W]);
        }
    }
    
}
