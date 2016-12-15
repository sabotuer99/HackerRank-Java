package algorithms.strings;

import java.util.Scanner;

public class SuperReducedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        in.close();
        StringBuilder sb = new StringBuilder();
        
        boolean changed = false;
        do{
            changed = false;
            for(int i = 0; i < word.length(); i++){
                if(i == word.length() - 1 || word.charAt(i) != word.charAt(i+1)){
                    sb.append(word.charAt(i));
                } else {
                    changed = true;
                    i++;
                }
            }
            word = sb.toString();
            sb.setLength(0);
        } while(changed);
        String result = "Empty String";
        if(word.length() > 0){
            result = word;
        }
        System.out.println(result);
    }
}
