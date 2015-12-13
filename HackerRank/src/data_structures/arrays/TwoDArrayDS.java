package data_structures.arrays;

import java.util.Scanner;

public class TwoDArrayDS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[6][6];
        for(int row = 0; row < 6; row++){
            for(int col = 0; col < 6; col++){
                grid[row][col] = in.nextInt();
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int row = 1; row < 5; row++){
            for(int col = 1; col < 5; col++){
                int hsum = grid[row-1][col-1] + grid[row-1][col] + grid[row-1][col+1] +
                                                grid[row][col] + 
                           grid[row+1][col-1] + grid[row+1][col] + grid[row+1][col+1];
                if(hsum > max)
                    max = hsum;
            }
        }
        
        System.out.println(max);
        
    }
}
