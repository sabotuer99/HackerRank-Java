import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int superDigit(String n, int k) {
        char[] digits = n.toCharArray();
        long sum = 0;
        for(int i = 0; i < digits.length; i++){
            sum += digits[i] - '0';
        }
        
        sum *= k;
        
        if(sum < 10){
            return (int)sum;
        } else {
            return superDigit(String.valueOf(sum), 1);
        }       
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        int result = superDigit(n, k);
        System.out.println(result);
        in.close();
    }
}
