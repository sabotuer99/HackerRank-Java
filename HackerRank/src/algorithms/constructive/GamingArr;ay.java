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
            int n = in.nextInt();
            int moves = 0;
            int max = 0;
            for(int i = 0; i < n; i++){
                int next = in.nextInt();
                if(next > max){
                    moves++;
                    max = next;
                }                                              
            }
            
            System.out.println(moves%2 == 0 ? "ANDY" : "BOB");                       
        }
    }
}
