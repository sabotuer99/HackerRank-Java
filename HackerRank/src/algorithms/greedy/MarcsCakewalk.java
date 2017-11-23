import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] calories = new Integer[n];
        for(int calories_i=0; calories_i < n; calories_i++){
            calories[calories_i] = in.nextInt();
        }
        // your code goes here
        Arrays.sort(calories, Collections.reverseOrder());
        
        long min = 0;
        for(int i = 0; i < n; i++){
            min += Math.pow(2,i) * calories[i];
        }
        
        System.out.println(min);
    }
}
