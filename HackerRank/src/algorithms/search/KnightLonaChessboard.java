import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Coord{
        
        public Coord(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
        
        public int row;
        public int col;
        public int dist;
    }
    
    
    public static int getMin(int n, int a, int b){
        
        //System.out.println(n + " " + a + " " + b);
        
        int[][] mins = new int[n][n];
        initialize(mins, -1);
        
        List<Coord> moves = getMoves(0,0,a,b,n,0);
        Deque<Coord> visited = new ArrayDeque<>(moves);
        
        //System.out.println("Started with " + visited.size() + " moves...");
        
        while(visited.size() > 0){
            Coord next = visited.poll();
            int row = next.row;
            int col = next.col;
            
            if(mins[row][col] == -1 || mins[row][col] > next.dist){
                mins[next.row][next.col] = next.dist;
                visited.addAll(getMoves(next.row,next.col,a,b,n,next.dist));
            }
        }
                
        return mins[n-1][n-1];
    }
    
    public static List<Coord> getMoves(int row, int col, int a, int b, int n, int dist){
        
        List<Coord> coords = new ArrayList<>();
        safeOffset(row,col,a,b,n,dist,coords);
        safeOffset(row,col,-a,b,n,dist,coords);
        safeOffset(row,col,a,-b,n,dist,coords);
        safeOffset(row,col,-a,-b,n,dist,coords);
        safeOffset(row,col,b,a,n,dist,coords);
        safeOffset(row,col,-b,a,n,dist,coords);
        safeOffset(row,col,b,-a,n,dist,coords);
        safeOffset(row,col,-b,-a,n,dist,coords);
        return coords;
    }
    
    public static void safeOffset(int row, int col, int a, int b, int n, int dist, List<Coord> coords){
        
        int orow = row + a;
        int ocol = col + b;
        
        if(orow >= 0 && orow < n && ocol >= 0 && ocol < n){
            coords.add(new Coord(orow, ocol, dist + 1));
        }
    }
    

    

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int[][] mins = new int[n-1][n-1];
        initialize(mins, -1);
        
        for(int a = 1; a < n; a++){
            for(int b = 1; b < n; b++){                
                mins[a-1][b-1] = getMin(n, a, b);               
            }
        }
        
        print(mins);        
    }
    
    
    public static void initialize(int[][] arr, int value){
        int n = arr.length;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                arr[row][col] = value;
            }
        }   
    }
    
    public static void print(int[][] arr){
        int n = arr.length;
        for(int row = 0; row < n; row++){
            String line = "";
            for(int col = 0; col < n; col++){
                line += arr[row][col] + " ";
            }
            line.substring(0,line.length()-1);
            System.out.println(line);
        }
    }
}
