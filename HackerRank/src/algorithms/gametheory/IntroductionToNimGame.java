import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        for(int T = in.nextInt(); T > 0; T--){
            int N = in.nextInt();
            
            int nimSum = 0;
            for(int i = 0; i < N; i++){
                int next = in.nextInt();
                
                nimSum ^= next;
            }
                
            boolean firstWins = nimSum != 0;
            System.out.println(firstWins ? "First" : "Second");
            
        }
        
    }
}
