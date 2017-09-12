package algorithms.implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int solve(int n, int p){
        // page turns from the front
        int front = p/2;
        
        // page turns from the back
        int back = ((n - p) + 1 - (n%2))/2;

        return Math.min(front, back);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
        in.close();
    }
}
