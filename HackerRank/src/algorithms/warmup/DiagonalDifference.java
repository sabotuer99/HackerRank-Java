package algorithms.warmup;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t;
        int sum = 0;
        
        t = in.nextInt();
        int[][] a = new int[t][t];
        
        for (int i=0; i<(t*t); i++) {
            int row = (int)Math.floor(i / t);
            int col = i % t;            
            a[row][col] = in.nextInt();           
        }
        
        int diag1 = 0;
        int diag2 = 0;
        
        for (int i=0; i<t; i++) {          
            diag1 += a[i][i];   
            diag2 += a[i][t - i - 1];
        }
        
        System.out.println(Math.abs(diag1 - diag2));
    }
}
