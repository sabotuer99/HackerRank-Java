package algorithms.dp;

import java.util.Scanner;

public class TheCoinChangeProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] S = new int[m];
        
        for(int i = 0; i < m; i++)
            S[i] = in.nextInt();
        
        long[][] table = new long[n+1][m];
        
        for (int i=0; i<m; i++)
            table[0][i] = 1L;
        
        for (int i = 1; i < n+1; i++)
        {
            for (int j = 0; j < m; j++)
            {
                // Count of solutions including S[j]
                long x = (i-S[j] >= 0)? table[i - S[j]][j]: 0;

                // Count of solutions excluding S[j]
                long y = (j >= 1)? table[i][j-1]: 0;

                // total count
                table[i][j] = x + y;
            }
        }
        
        System.out.println(table[n][m-1]);  
    }
}
