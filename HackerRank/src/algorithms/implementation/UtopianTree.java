package algorithms.implementation;

import java.util.Scanner;

public class UtopianTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(; t > 0; t--){
            int i = in.nextInt();
            long height = 1;
            for(; i > 0; i--){
                if((height & 1L) == 1){
                    height <<= 1;
                } else {
                    height += 1;
                }
            }
            System.out.println(height);
        }
    }
}
