package algorithms.strings;

import java.util.Scanner;

public class TheLoveLetterMystery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(; t > 0; t--){
            
            char[] line = in.nextLine().toCharArray();
            int operations = 0;
            for(int i = 0; i < line.length / 2; i++){
                int j = line.length - 1 - i;
                if(line[i] != line[j]){
                    operations += Math.abs(line[i] - line[j]);
                }
            }
            System.out.println(operations);
        }
    }
}
