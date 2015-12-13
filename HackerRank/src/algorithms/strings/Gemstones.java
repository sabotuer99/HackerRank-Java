package algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Gemstones {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ArrayList<Character> alphabet = 
            new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                                        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        int t = in.nextInt();
        in.nextLine();
        for(; t > 0; t--){
            String line = in.nextLine();
            
            List<Character> elements = new ArrayList<Character>();
            
            for(int i = 0; i < line.length(); i++){
                elements.add(new Character(line.charAt(i)));
            }
            
            //System.out.println(line + " " + elements.size());
            alphabet.retainAll(elements);
        }
        
        System.out.println(alphabet.size());
    }
}
