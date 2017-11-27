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
            int M = in.nextInt();
            
            //if M == 1, Player 1 has no move, loses
            if(M == 1){
                System.out.println(2);
                continue;
            }
            
            //if N is even, player 2 can play mirror strategy and win
            System.out.println(N%2 == 0 ? 2 : 1);
        }
            
     }
}
