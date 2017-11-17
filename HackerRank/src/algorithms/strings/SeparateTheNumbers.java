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
            String s = in.next();
            // your code goes here
            String answer = "NO";
            for(int startSize = 1; startSize <= s.length() / 2; startSize++){
                
                int tokenSize = startSize;
                String lastToken = s.substring(0, tokenSize);
                long lastTokenValue = Long.parseLong(lastToken);
                int i = startSize;
                for(; i <= s.length() - tokenSize; i += tokenSize){
                 
                    if(Pattern.matches("^9+$",lastToken)){
                        tokenSize++;
                    }                   
                    
                    String token = s.substring(i, i + tokenSize);
                    
                    //System.out.println("Token == " + token);
                    
                    if(token.toCharArray()[0] == '0'){
                        break;
                    }
                    
                    long tokenValue = Long.parseLong(token);
                    if(tokenValue - lastTokenValue == 1){
                        lastTokenValue = tokenValue;
                        lastToken = token;
                    } else {
                        break;
                    }
                    
                }
                
                //System.out.print(i + " ");
                if(i == s.length()){
                    answer = "YES " + s.substring(0, startSize);
                    break;
                }
            }
            
            System.out.println(answer);
        }
    }
}
