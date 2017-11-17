import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            char[] s = in.next().toCharArray();
            // your code goes here
            char[] h = "hackerrank".toCharArray();
            int i = 0;
            for(int j = 0; i < h.length && j < s.length; j++){
                if(h[i] == s[j]){
                    i++;
                }
            }
            
            String answer = i == h.length ? "YES" : "NO";
            System.out.println(answer);
        }
    }
}
