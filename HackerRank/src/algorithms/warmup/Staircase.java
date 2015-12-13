package algorithms.warmup;

import java.util.Scanner;

public class Staircase {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        for(int i = 0; i < N; i++){
            for(int zeros = N - i - 1; zeros > 0; zeros--)
                System.out.print(" ");
            for(int pounds = i + 1; pounds > 0; pounds--)
                System.out.print("#");
            System.out.println();
        }
    }
}
