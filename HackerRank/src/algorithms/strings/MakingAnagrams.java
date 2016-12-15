package algorithms.strings;

import java.util.Scanner;

public class MakingAnagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] first = in.next().toCharArray();
        char[] second = in.next().toCharArray();
        
        in.close();
        
        char[] firstCounts = new char[26];
        char[] secondCounts = new char[26];
        
        for(char letter : first){
            firstCounts[letter - 'a']++;
        }
        
        for(char letter : second){
            secondCounts[letter - 'a']++;
        }
        
        int deletions = 0;
        for(int i = 0; i < 26; i++){
            deletions += Math.abs(firstCounts[i] - secondCounts[i]);
        }
        
        System.out.println(deletions);
    }
}
