package algorithms.implementation;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
            in.nextLine();
        String word = in.nextLine();
        int shift = in.nextInt();
        
        StringBuilder sb = new StringBuilder();
        int a = "a".charAt(0);
        int z = "z".charAt(0);
        int A = "A".charAt(0);
        int Z = "Z".charAt(0);
        
        for(int i = 0; i < N; i++){
            char letter = word.charAt(i);
            if(letter >= a && letter <= z){
                int offset = letter - a;
                offset += shift;
                offset %= z - a + 1;
                letter = (char)(a + offset);
            } else if(letter >= A && letter <= Z){
                int offset = letter - A;
                offset += shift;
                offset %= Z - A + 1;
                letter = (char)(A + offset);
            } 
            
            sb.append(letter);
        }
        
        System.out.println(sb.toString());
    }
}
