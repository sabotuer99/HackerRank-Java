package algorithms.dp;

import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(; t > 0; t--){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }
            
            int[] DP = new int[k+1];
            
            for(int j = 1; j <= k; j++){
                
                int prev = 0;
                if(j > 0)
                    prev = DP[j-1];
                
                int imax = 0;
                for(int i = 0; i < n; i++){
                    int M = 0;
                    if(j >= nums[i]){
                        M = DP[j-nums[i]] + nums[i];
                    }
                    imax = M > imax ? M : imax;
                }
                
                DP[j] = prev > imax ? prev : imax;
            }
            //System.out.println(Arrays.toString(DP));
            System.out.println(DP[k]);
        }
    }
}
