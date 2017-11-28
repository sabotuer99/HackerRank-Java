import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        
        boolean[][] wins = new boolean[15][15];
        for(int i = 0; i < 30; i++){
            for(int j = 0; j <= i; j++){
                
                int row = i - j;
                int col = j;
                
                if(row < 15 && col < 15){
                    
                    wins[row][col] = (row - 2 >= 0 && col + 1 < 15 && !wins[row - 2][col + 1]) ||
                                     (row - 2 >= 0 && col - 1 >= 0 && !wins[row - 2][col - 1]) ||
                                     (row + 1 < 15 && col - 2 >= 0 && !wins[row + 1][col - 2]) ||
                                     (row - 1 >= 0 && col - 2 >= 0 && !wins[row - 1][col - 2]);    
                }                           
            }                  
        }
        
        /*
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                System.out.print(wins[i][j] ? "1 " : "2 ");
            }
            System.out.println("\n");
        }*/
        
        
        Scanner in = new Scanner(System.in);
        
        for(int T = in.nextInt(); T > 0; T--){
            
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            
            System.out.println(wins[y][x] ? "First" : "Second");
            
        }
        
        in.close();
    }
}
