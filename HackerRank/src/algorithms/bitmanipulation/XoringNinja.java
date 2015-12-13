package algorithms.bitmanipulation;

import java.math.BigInteger;
import java.util.Scanner;

public class XoringNinja {

    public static void main(String[] args) {
   /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i = 0; i < t; i += 1){
            
            int N = in.nextInt();
            BigInteger factor = BigInteger.valueOf(2);
            factor = factor.pow(N - 1);
            int accum = 0;
            
            for(int j = 0; j < N; j++){
                accum |= in.nextInt();
            }
            
            BigInteger result = factor.multiply(BigInteger.valueOf(accum)).mod(BigInteger.valueOf(1000000007));
            
            System.out.println(result);
            
        }
        
        
    }
}
