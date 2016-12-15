package algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoCharacters {

    public static boolean isValidT(String s){
        if(s.length() < 3){
            return true;
        }
        char[] valid = new char[2];
        valid[0] = s.charAt(0);
        valid[1] = s.charAt(1);
        
        if(valid[0] == valid[1]){
            return false;
        }
        
        for(int i = 2; i < s.length(); i++){
            if(s.charAt(i) != valid[i%2] ){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        char[] s = in.next().toCharArray();
        in.close();
        
        StringBuilder sb = new StringBuilder();
        Set<Character> letters = new HashSet<>();
        //scan string
        for(int i = 0; i < s.length; i++){
            letters.add(s[i]);
        }
        
        //enumerate all possible strings, check valid, track max length
        int max = 0;
        for(Character letter1 : letters){
            for(Character letter2 : letters){
                if(letter1 == letter2){
                    continue;
                }
                
                for(int i = 0; i < s.length; i++){
                    char orig = s[i];
                    if(orig == letter1 || orig == letter2){
                        sb.append(orig);
                    }
                }
                
                String result = sb.toString();
                if(isValidT(result)){
                    //System.out.println(result);
                    max = Math.max(max, result.length());
                }
                sb.setLength(0);
            }
        }
        
        System.out.println(max);
    }
}
