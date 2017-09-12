package algorithms.implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int[] a = new int[n];
        //radix array
        int[] counts = new int[101];
        for(int i=0; i < n; i++){
            int a_i = in.nextInt();
            counts[a_i]++;
        }
        
        int max = 0; 
        for(int i = 0; i < 100; i++){
            max = Math.max(max, counts[i] + counts[i+1]);
        }
        
        System.out.println(max);
        in.close();
    }
}
