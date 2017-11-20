import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        char[] num = in.next().toCharArray();
        long[] addition = new long[num.length];
        long[] total = new long[num.length];
        
        addition[0] = num[0] - '0';
        total[0] = num[0] - '0';
        
        for(int i = 1;i < num.length; i++){
            addition[i] = (addition[i-1] * 10 + ((num[i] - '0') * (i+1))) % 1000000007;
            total[i] = (addition[i] + total[i-1]) % 1000000007;
            
        }
        
        //System.out.println(Arrays.toString(addition));
        //System.out.println(Arrays.toString(total));
        System.out.println(total[num.length - 1]);
        
    }
}
