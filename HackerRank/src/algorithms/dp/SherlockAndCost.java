import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        
        Scanner in = new Scanner(System.in);        
        for(int testCaseCount = in.nextInt();
                testCaseCount > 0; 
                testCaseCount--){
            int bN = in.nextInt();
            int[] B = new int[bN];
            int[][] dp = new int[2][bN];
            
            B[0] = in.nextInt();
            
            for(int i = 1; i < bN; i++){
                B[i] = in.nextInt();
                int BB = Math.abs(B[i-1] - B[i]);
                int BI = Math.abs(1      - B[i]);
                int IB = Math.abs(B[i-1] - 1   );
                int II = 0;
                
                dp[0][i] = Math.max(BB + dp[0][i-1], BI + dp[1][i-1]);
                dp[1][i] = Math.max(IB + dp[0][i-1], II + dp[1][i-1]);
                
                //System.out.println(Arrays.toString(dp[0]));
                //System.out.println(Arrays.toString(dp[1]));
            }
            
            System.out.println(Math.max(dp[0][bN-1], dp[1][bN-1]));
        }
        in.close();
    }
}
