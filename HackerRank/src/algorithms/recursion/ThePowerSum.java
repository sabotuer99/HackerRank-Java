import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int powerSums(int X, int N, int start){
        int val = (int)Math.pow(start,N);
        
        if(val > X){
            return 0;
        }
        
        if(val == X){
            return 1;
        }
        
        return powerSums(X - val, N, start + 1) + powerSums(X, N, start + 1);        
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int X = in.nextInt();
        int N = in.nextInt();
        in.close();
        
        System.out.println(powerSums(X,N,1));
                   
    }
}
