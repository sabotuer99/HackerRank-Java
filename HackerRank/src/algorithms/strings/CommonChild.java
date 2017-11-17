import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int commonChild(char[] s1, char[] s2){
        // Complete this function
        long start = System.currentTimeMillis();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        
        String ss1 = new String(s1);
        String ss2 = new String(s2);
        
        for(int j = 0; j < s2.length; j++){
            for(int i = 0; i < s1.length; i++){  
                int prev = Math.max(dp[i][j + 1], dp[i + 1][j]);
                if(s1[i] == s2[j]){
                    dp[i + 1][j + 1] = Math.max(prev, dp[i][j] + 1);
                } else {
                    dp[i + 1][j + 1] = prev;
                }
                
                //System.out.println(ss2.substring(0,j + 1) + " " + ss1.substring(0,i + 1));
                //for(int[] line : dp){
                //    System.out.println(Arrays.toString(line));
               // }
            }
        }
        
        return dp[s1.length][s2.length];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s1 = in.next().toCharArray();
        char[] s2 = in.next().toCharArray();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}
