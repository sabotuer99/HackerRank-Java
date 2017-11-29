import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        long[] a = new long[N];
        long nimSum = 0;
        
        for(int i = 0; i < N; i++){
            long next = in.nextLong();
            a[i] = next;
            nimSum ^= next;
        }
        
        int ways = 0;
        for(int j = 0; j < N; j++){
            ways += (nimSum ^ a[j]) < a[j] ? 1 : 0;
        }
        
        System.out.println(ways);
                
    }
}
