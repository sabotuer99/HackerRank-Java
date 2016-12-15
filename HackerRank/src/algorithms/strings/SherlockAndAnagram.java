package algorithms.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockAndAnagram {

    public static boolean isAnagram(String word1, String word2){
        if(word1 == null || word2 == null || word1.length() != word2.length()){
            return false;
        }
        
        int[] letterCount = new int[26];
        for(int i = 0; i < word1.length(); i++){
            letterCount[word1.charAt(i) - 'a']++;
            letterCount[word2.charAt(i) - 'a']--;
        }
        
        for(int i = 0; i < 26; i++){
            if(letterCount[i] != 0){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(;T > 0; T--){
            String string = in.next();
            List<List<String>> subs = new ArrayList<>();
            for(int i = 0; i <= string.length(); i++){
                subs.add(new ArrayList<String>());
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < string.length(); i++ ){
                sb.setLength(0);
                for(int j = i; j < string.length(); j++){
                    sb.append(string.charAt(j));
                    subs.get(j-i+1).add(sb.toString());
                }
            }
            
            int count = 0;
            for(int i = 1; i <= string.length(); i++){
                List<String> xsubs = subs.get(i);
                for(int j = 0; j < xsubs.size(); j++){
                    String first = xsubs.get(j);
                    for(int k = j + 1; k < xsubs.size(); k++){
                        String second = xsubs.get(k);
                        count += isAnagram(first, second) ? 1 : 0;
                    }
                }
            }
            
            System.out.println(count);
        }
        in.close();
    }
}
