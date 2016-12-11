package algorithms.bitmanipulation;

import java.util.Scanner;

public class FlippingBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        long mask = (1L << 32) - 1;
        //System.out.println(mask);
        for(; T > 0; T--){
            long n = in.nextLong();
            System.out.println(n ^ mask);
        }
        in.close();
    }
}
