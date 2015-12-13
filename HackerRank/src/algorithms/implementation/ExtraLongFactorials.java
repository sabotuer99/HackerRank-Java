package algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        BigInteger result = BigInteger.valueOf(1);
        
        for(int i = N; i > 0; i--){
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        System.out.println(result);
    }
}
