package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class TheGridSearch {
    public static void main(String[] args) {
             
        Scanner in = new Scanner(System.in);
        
        for(int t = in.nextInt(); t > 0; t--){
        
            int R = in.nextInt();
            int C = in.nextInt();
            int[][] array = new int[R][C];
            in.nextLine();

            for(int i = 0; i < R; i++){
                char[] line = in.nextLine().toCharArray();
                for(int j = 0; j < C; j++){
                    array[i][j] = (int)line[j];
                }
            }

            int r = in.nextInt();
            int c = in.nextInt();
            int[][] query = new int[r][c];
            in.nextLine();

            for(int i = 0; i < r; i++){
                char[] line = in.nextLine().toCharArray();
                for(int j = 0; j < c; j++){
                    query[i][j] = (int)line[j];
                }
            }

            boolean match = false;
            for(int i = 0; i < (R - r + 1) && !match; i++){
                for(int j = 0; j < (C - c + 1) && !match; j++){
                    match = match(array, query, j, i, r, c);
                }
            }

            String result = match ? "YES" : "NO";
            System.out.println(result);
        }
    }
    
    static boolean match(int[][] array, int[][] query, int x, int y, int r, int c){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(array[y + i][x + j] != query[i][j])
                    return false;
            }
        }
        return true;
    }
    
    static void printArray(int[][] array){
        for(int i = 0; i < array.length; i++)
            Arrays.toString(array[i]);
    }
}
