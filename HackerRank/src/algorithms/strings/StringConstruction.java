package algorithms.strings;

import java.util.Scanner;

public class StringConstruction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            char[] s = in.next().toCharArray();
            int[] counts = new int[26];
            for(int i = 0; i < s.length; i++){
                counts[s[i]-'a']++;
            }
            int cost = 0; 
            for(int c : counts){
                cost += c > 0 ? 1 : 0;
            }
            System.out.println(cost);
        }
        in.close();
    }
}
