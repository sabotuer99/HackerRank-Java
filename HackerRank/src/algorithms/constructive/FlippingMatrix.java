package algorithms.constructive;

import java.util.Scanner;

public class FlippingMatrix {

    public static int maxQ2(int[][] a, int n){
        int lastIndex = 2 * n - 1;
        int max = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                int mrow = lastIndex - row;
                int mcol = lastIndex - col;
                int best = a[row][col];
                best = Math.max(best, a[mrow][col]);
                best = Math.max(best, a[row][mcol]);
                best = Math.max(best, a[mrow][mcol]);
                max += best;
            }
        }
        return max;        
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(; T >0 ; T--){
            int n = in.nextInt();
            int[][] a = new int[n * 2][n * 2];
            for(int row = 0; row < 2 * n; row++){
                for(int col = 0; col < 2 * n; col++){
                    a[row][col] = in.nextInt();
                }
            }
            
            System.out.println(maxQ2(a, n));
        }
        in.close();
    }
}
