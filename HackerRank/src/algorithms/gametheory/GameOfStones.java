import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        boolean[] wins = new boolean[101];
        for(int i = 0; i <= 100; i++){
            wins[i] = (i >= 2 && !wins[i-2]) ||
                      (i >= 3 && !wins[i-3]) ||
                      (i >= 5 && !wins[i-5]) ;                            
        }
        
        
        
        for(int T = in.nextInt(); T > 0; T--){
            
            int stones = in.nextInt();
            System.out.println(wins[stones] ? "First" : "Second");
   
        }
        
        
    }
}
