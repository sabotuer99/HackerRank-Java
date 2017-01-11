package algorithms.search;

import java.util.Scanner;

public class ConnectedCellsInGrid {

    public static int dfs(int[][] arr, int row, int col){
        if(row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] == 0){
            return 0;
        }
        
        int size = 1;
        arr[row][col] = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                size += dfs(arr, row + i, col + j);
            }
        }
        
        return size;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++ ){
                grid[row][col] = in.nextInt();
            }
        }
        in.close();
        
        int max = 0; 
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++ ){
                max = Math.max(max, dfs(grid, row, col));
            }
        }
        
        System.out.println(max);
        
     }
}
