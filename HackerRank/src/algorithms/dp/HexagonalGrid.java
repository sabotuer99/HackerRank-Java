package algorithms.dp;

import java.util.HashSet;
import java.util.Scanner;

public class HexagonalGrid {
    
    public static class Tuple{
        public int row;
        public int col;
        
        public Tuple(int row, int col){
            this.row = row;
            this.col = col;
        }
        
        @Override
        public boolean equals(Object o){
            if(o == null)
                return false;
            
            if(o instanceof Tuple){
                Tuple other = (Tuple)o;
                return this.row == other.row && this.col == other.col;
            } else {
                return false;
            }
        }
        
        @Override
        public int hashCode(){
            return row << 16 + col;
        }
    }
    
    public static void findAdjacent(char[][] grid, int[][] sizes, int row, int col){
        HashSet<Tuple> nodes = new HashSet<Tuple>();
        HashSet<Tuple> next = new HashSet<Tuple>();
        nodes.add(new Tuple(row, col));
        next.add(new Tuple(row, col));
        
        while(next.size() > 0){
            HashSet<Tuple> temp = next;
            next = new HashSet<Tuple>();
            
            //if row == 0, look right and down and down-left
            //if row == 1, look right and up and up-right
            //only add a node to next if it is not in 'nodes' and is not 'black'
            for(Tuple node : temp){
               
                // check right
                if(node.col < grid[0].length - 1 && grid[node.row][node.col + 1] != '1'){
                    Tuple neighbor = new Tuple(node.row, node.col + 1);
                    if(!nodes.contains(neighbor)){
                        next.add(neighbor);
                        nodes.add(neighbor);
                    }
                }
                
                if(node.row == 0){
                    // check down
                    if(grid[1][node.col] != '1'){
                        Tuple neighbor = new Tuple(1, node.col);
                        if(!nodes.contains(neighbor)){
                            next.add(neighbor);
                            nodes.add(neighbor);
                        }
                    }
                    // check down-left
                    if(node.col > 0 && grid[1][node.col-1] != '1'){
                        Tuple neighbor = new Tuple(1, node.col-1);
                        if(!nodes.contains(neighbor)){
                            next.add(neighbor);
                            nodes.add(neighbor);
                        }
                    }
                } else {
                    // check up
                    if(grid[0][node.col] != '1'){
                        Tuple neighbor = new Tuple(0, node.col);
                        if(!nodes.contains(neighbor)){
                            next.add(neighbor);
                            nodes.add(neighbor);
                        }
                    }
                    // check up-right
                    if(node.col < grid[0].length - 1 && grid[0][node.col+1] != '1'){
                        Tuple neighbor = new Tuple(0, node.col+1);
                        if(!nodes.contains(neighbor)){
                            next.add(neighbor);
                            nodes.add(neighbor);
                        }
                    }
                }
            }
        }
        
        int size = nodes.size();
        for(Tuple node : nodes){
            sizes[node.row][node.col] = size;
        }
        
        //System.out.println(Arrays.toString(sizes[0]));
        //System.out.println(Arrays.toString(sizes[1]));
    }
    
    
    public static boolean isValid(char[][] grid){
        
        
        int[][] sizes = new int[2][grid[0].length];
        
        
        for(int col = 0; col < grid[0].length; col++){
            for(int row = 0; row < 2; row++){
                if(grid[row][col] == '1'){
                    sizes[row][col] = -1;
                } else {
                    if(sizes[row][col] == 0)
                        findAdjacent(grid, sizes, row, col);
                    
                    if(sizes[row][col] % 2 == 1)    
                        return false;
                }
            }
        }
        
        return true;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(; t > 0; t--){
            int N = in.nextInt();
            in.nextLine();
            char[][] grid = new char[2][N];
            grid[0] = in.nextLine().toCharArray();
            grid[1] = in.nextLine().toCharArray();
            
            String result = isValid(grid) ? "YES" : "NO";
            System.out.println(result);
        }
    }
}
