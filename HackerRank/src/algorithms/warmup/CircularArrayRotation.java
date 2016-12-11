package algorithms.warmup;

import java.util.Scanner;

public class CircularArrayRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            
            int index = (n + m - k)%n;
            
            index = index < 0 ? n + index : index;
            
            System.out.println(a[index]);
            
            
            
        }
        in.close();
    }
}
