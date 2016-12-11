package algorithms.warmup;

import java.util.Scanner;

public class CompareTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        
        int alice = a0 > b0 ? 1 : 0;
        alice += a1 > b1 ? 1 : 0;
        alice += a2 > b2 ? 1 : 0;
        
        int bob = a0 < b0 ? 1 : 0;
        bob += a1 < b1 ? 1 : 0;
        bob += a2 < b2 ? 1 : 0;
        
        System.out.printf("%d %d", alice, bob);
        in.close();
    }
}
