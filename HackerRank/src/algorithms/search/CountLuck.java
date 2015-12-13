package algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountLuck {
	   
    public static void log(Object message){
        //System.out.println(message);
    }
    
    public static enum Dir{
        START,
        EAST,
        WEST,
        NORTH,
        SOUTH
    }
    
    public static class Move{
        
        public Move(int x, int y, Dir dirFrom){
            this.x = x;
            this.y = y;
            this.dirFrom = dirFrom;
        }
        
        public int x;
        public int y;
        public Dir dirFrom;
    }
    
    public static int waved = 0;
    public static boolean findExit(char[][] map, int x, int y, Dir prev){
        
        //if this is the exit, return true
        if(map[y][x] == '*'){
            log("Found at " + x + " " + y);
            return true;
        }
            
        
        //for each valid direction, except previous location, check if valid move
        //if move is valid, try to find exit in that direction
        boolean exitFound = false;
        List<Move> moves = getValidMoves(map, x, y, prev);
        
        //if there are no moves, this is a dead end
        if(moves.size() == 0)
            return false;
        
        for(Move move : moves){
            exitFound = findExit(map, move.x, move.y, move.dirFrom);
            if(exitFound)
                break;
        }
        
        //if exit is found and this node is a fork, increment waved
        if(exitFound && moves.size() > 1)
            waved += 1;
        
        if(exitFound)
            log(x + " " + y + "  | " + waved);
        
        return exitFound;
    }
    
    public static List<Move> getValidMoves(char[][] map, int x, int y, Dir prev){
        //for each valid direction, except previous direction, check if valid move
        //if move is valid, try to find exit in that direction
        List<Move> moves = new ArrayList<Move>();
        
        //NORTH
        if(prev != Dir.NORTH && isValidMove(map, x, y - 1))
            moves.add(new Move(x, y-1, Dir.SOUTH));
            
        //SOUTH
        if(prev != Dir.SOUTH && isValidMove(map, x, y + 1))
            moves.add(new Move(x, y+1, Dir.NORTH));
        
        //WEST
        if(prev != Dir.WEST && isValidMove(map, x - 1, y))
            moves.add(new Move(x-1, y, Dir.EAST));
        
        //EAST
        if(prev != Dir.EAST && isValidMove(map, x + 1, y))
            moves.add(new Move(x+1, y, Dir.WEST));
        
        return moves;
    }
    
    public static boolean isValidMove(char[][] map, int x, int y){
        //get bounds
        int xmin = 0;
        int ymin = 0;
        int xmax = map[0].length - 1;
        int ymax = map.length - 1;
        
        //check that move is in bounds
        if(x < xmin || y < ymin || x > xmax || y > ymax)
            return false;
        
        //check if destination is 'X'
        if(map[y][x] == 'X')
            return false;
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        
        for(; t > 0; t--){
            waved = 0;
            int rows = in.nextInt();
            int cols = in.nextInt();
            char[][] map = new char[rows][cols];
            in.nextLine();
            for(int i = 0; i < rows; i++){
                map[i] = in.nextLine().toCharArray();
            }
            int mx = -1;
            int my = -1;
            for(int i = 0; i < rows && mx < 0; i++){
                for(int j = 0; j < cols && mx < 0; j++){
                    if(map[i][j] == 'M'){
                        mx = j;
                        my = i;
            }}}
            
            findExit(map, mx, my, Dir.START);
            
            int K = in.nextInt();
            if(K == waved){
                System.out.println("Impressed");
            } else {
                System.out.println("Oops!");
            }
        }
    }
}
