package algorithms.implementation;

import java.util.Scanner;

public class CavityMap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        
        char[][] grid = new char[N][N];
        
        for(int i = 0; i < N; i++){
            grid[i] = in.nextLine().toCharArray();
        }
        
        
        for(int i = 0; i < N; i++){            
            for(int j = 0; j < N; j++){
                
                if(i == 0 || i == N - 1 || j == 0 || j == N - 1){
                    System.out.print(grid[i][j]);
                } else {
                    char v = grid[i][j];
                    if(grid[i - 1][j] < v && grid[i + 1][j] < v && grid[i][j - 1] < v && grid[i][j + 1] < v)
                        v = 'X';
                    System.out.print(v);
                }
                    
            }
            System.out.println();
        }
        
    }
}
