package algorithms.implementation;

import java.util.Scanner;

public class SherlockAndSquares {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(;T > 0; T--){
            int a = in.nextInt();
            int b = in.nextInt();
            
            int start = (int) Math.sqrt(a);
            if(start * start < a){
                start++;
            }
            
            int squares = 0;
            for(;start * start <= b; start++){
                squares++;
            }
            System.out.println(squares);
        }
        in.close();
    }
}
