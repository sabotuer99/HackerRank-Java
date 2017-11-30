import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long theGreatXor(long x){
        
        long total = 0;
        for(int i = 0; (x >>> i) > 0; i++){
            if(((x >>> i) & 1) == 0){
                total += 1L << i;
            }
        }        
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
    }
}
