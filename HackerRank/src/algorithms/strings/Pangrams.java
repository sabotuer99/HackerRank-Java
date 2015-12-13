package algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pangrams {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().toLowerCase();
        
        ArrayList<Character> alphabet = 
            new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                                        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        
        for(int i = 0; i < line.length(); i++){
            alphabet.remove(new Character(line.charAt(i)));
            if(alphabet.size() == 0){
                System.out.println("pangram");
                return;
            }
        }
        System.out.println("not pangram");
        
    }
}
