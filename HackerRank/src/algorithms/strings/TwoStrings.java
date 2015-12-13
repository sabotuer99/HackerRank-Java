package algorithms.strings;

import java.util.Scanner;

public class TwoStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        
        for(; t > 0; t--){
            char[] word1 = in.nextLine().toCharArray();
            char[] word2 = in.nextLine().toCharArray();
            char[] seen = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            
            for(int i = 0; i < word1.length; i++){
                int index = (int)(word1[i] - 'a');
                seen[index] += 1;
            }
            boolean found = false;
            for(int i = 0; i < word2.length && !found; i++){
                int index = (int)(word2[i] - 'a');
                if(seen[index] > 0){
                    System.out.println("YES");
                    found = true;
                }
            }
            if(!found)
                System.out.println("NO");
        }
    }
}
