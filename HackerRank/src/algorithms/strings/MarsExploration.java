package algorithms.strings;

import java.util.Scanner;

public class MarsExploration {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] S = in.next().toCharArray();
        in.close();
        
        int changed = 0;
        for(int i = 0; i < S.length; i += 3){
            changed += S[i] == 'S' ? 0 : 1;
            changed += S[i+1] == 'O' ? 0 : 1;
            changed += S[i+2] == 'S' ? 0 : 1;
        }
        
        System.out.println(changed);
        
    }
}
