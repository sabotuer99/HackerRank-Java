package algorithms.warmup;

import java.util.Scanner;

public class AVeryBigSum {
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t;
        long sum = 0;
        int a,b;
        t = in.nextInt();
        for (int i=0;i<t;i++) {
            a = in.nextInt();
            sum += a;            
        }
        System.out.println(sum);
    }
}
