package algorithms.strings;

import java.util.Scanner;

public class AlternatingCharacters {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        
        for(int i = 0; i < t; i++){
            byte[] line = in.nextLine().getBytes();
            int count=0;
            
            for(int j = 1; j < line.length; j++){
                if(line[j] == line[j-1])
                    count += 1;
            }
            
            System.out.println(count);
            
        }
    }
}
