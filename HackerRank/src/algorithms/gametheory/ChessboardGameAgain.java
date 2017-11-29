import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        //This blog post was instrumental in helping me understand and solve this problem
        //https://fatemasaifee.wordpress.com/2014/08/30/algorithm-games-sprague-grundy-theorem/
        int[][] grundy = new int[15][15];
        for(int i = 0; i < 30; i++){
            for(int j = 0; j <= i; j++){
                
                int row = i - j;
                int col = j;
                
                if(row < 15 && col < 15){  
                    Set<Integer> g = new HashSet<>();
                    
                    safeAdd(g, grundy, row - 2, col + 1);
                    safeAdd(g, grundy, row - 2, col - 1);
                    safeAdd(g, grundy, row + 1, col - 2);
                    safeAdd(g, grundy, row - 1, col - 2);
                    
                    if(g.size() == 0){
                        grundy[row][col] = 0;
                    } else {
                        
                        int smallestMissing = 0;
                        while(g.contains(smallestMissing)){
                            smallestMissing++;
                        }                                               
                        grundy[row][col] = smallestMissing;
                    }
                }
            }
        }            
        
        /*
        for(int i = 0; i < 15; i++){
            System.out.println(Arrays.toString(grundy[i]));
        }*/
        
        
        Scanner in = new Scanner(System.in);
        for(int T = in.nextInt(); T > 0; T--){
            int k = in.nextInt();
            int nimber = 0;           
            for(int i = 0; i < k; i++){
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                nimber ^= grundy[x][y];
            }      
            
            System.out.println(nimber > 0 ? "First" : "Second");
        }
    }
    
    private static void safeAdd(Set<Integer> g, int[][] grundy, int row, int col){
        if(row >= 0 && row < 15 && col >= 0 && col < 15){
            g.add(grundy[row][col]);
        }
    }
}
