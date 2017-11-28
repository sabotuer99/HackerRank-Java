import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(in.hasNext()){
            int N = in.nextInt();
            
            long nimSum = 0;
            for(int i = 0; i < N; i++){
                long next = in.nextLong();
                
                if(i > 0 && next%2 == 1){
                    nimSum ^= i;
                }                
            }
                
            boolean firstWins = nimSum != 0;
            System.out.println(firstWins ? "First" : "Second");
            
        }
        in.close();
    }
}
