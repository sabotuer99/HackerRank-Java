import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        //get the primes less than 1 to 10^5 
        
        int[] primes = new int[100001];
        int pCount = 1;
        primes[2] = 1;
        for(int i = 3; i < 100000; i += 2){
            pCount += BigInteger.valueOf(i).isProbablePrime(100) ? 1 : 0;
            primes[i] = pCount;
            primes[i+1] = pCount;
        }
        
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            
            System.out.println(primes[n]%2 == 0 ? "Bob" : "Alice");
        }
    }
}
