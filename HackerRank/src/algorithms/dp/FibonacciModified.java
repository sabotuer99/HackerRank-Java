package algorithms.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        BigInteger a = BigInteger.valueOf(in.nextInt());
        BigInteger b = BigInteger.valueOf(in.nextInt());
        int n = in.nextInt();

        System.out.println(fib(a, b, n - 2));
    }
    
    static BigInteger fib(BigInteger a, BigInteger b, int n){
        BigInteger c = (b.multiply(b)).add(a);
        //System.out.println(a + " | " + b + " | " + c + " | " + n);
        if(n == 1)
            return c;
        else
            return fib(b, c, n - 1);
    }
}
