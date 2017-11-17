import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        int n = in.nextInt();
        
        int lastWeight = getWeight(s[0]);
        int lastLetter = s[0];
        Set<Integer> weights = new HashSet<>();
        weights.add(lastWeight);
        
        for(int i = 1; i < s.length; i++){
            int thisWeight = getWeight(s[i]);
            if(lastLetter == s[i]){
                lastWeight += thisWeight;
            } else {
                lastLetter = s[i];
                lastWeight = thisWeight;
            }
            
            weights.add(lastWeight);
        }
        
        StringBuilder answers = new StringBuilder();

        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            // your code goes here
            answers.append(weights.contains(x) ? "Yes\n" : "No\n");
        }
        
        answers.setLength(answers.length() - 1);
        System.out.println(answers.toString());
    }
    
    public static int getWeight(char letter){
        return letter - 'a' + 1;
    }
}
