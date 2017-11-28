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
            int ones = 0;
            
            for(int i = 0; i < N; i++){
                int next = in.nextInt();
                ones += next == 1 ? 1 : 0;
                nimSum ^= next;
            }
                
            //MISERE MOD
            
            boolean allones = ones == N;
            boolean evenones = ones%2 == 0;
            boolean zeroNim = nimSum == 0;
            
            boolean firstWins = (allones && evenones) || (!allones && !zeroNim);
            System.out.println(firstWins ? "First" : "Second");
            
        }
    }
}
