package algorithms.implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getMoneySpent(int[] keyboards, int[] drives, int s){
        // sort arrays
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        
        //two finger walk through the arrays
        int max = -1;
        int ki = 0;
        int di = drives.length - 1;
        
        while(ki < keyboards.length && di >= 0){
            int cost = keyboards[ki] + drives[di];
            if(cost > s){
                di--;
            } else {
                max = Math.max(max, cost);
                ki++;
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
        
        in.close();
    }
}
