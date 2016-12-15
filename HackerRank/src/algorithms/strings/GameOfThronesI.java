package algorithms.strings;

import java.util.Scanner;

public class GameOfThronesI {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        int[] letterCount = new int[26];

        for(char letter : s){
            letterCount[letter - 'a']++;
        }
        
        int odds = 0;
        for(int count : letterCount){
            if(count%2==1){
                odds++;
            }
        }
        
        String ans = odds > 1 ? "NO" : "YES";
        
        System.out.println(ans);
        in.close();
    }
}
