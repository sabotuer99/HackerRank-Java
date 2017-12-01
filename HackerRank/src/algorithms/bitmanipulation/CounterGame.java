import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        for(int T = in.nextInt(); T > 0; T--){
            long N = in.nextLong();
            
            int turns = 0; 
            
            for(; N > 1; turns++){
                
                if( (N & (N-1)) == 0){
                    N >>>= 1;
                } else {
                    N -= 1L << binlog(N);
                }  
            }
            
            System.out.println(turns%2 == 0 ? "Richard" : "Louise" );
         } 
    }
    
    //https://stackoverflow.com/a/3305710
    public static int binlog( long bits )
    {
        if( bits == 0 )
            return 0; // or throw exception
        return 63 - Long.numberOfLeadingZeros( bits );
    }
}
