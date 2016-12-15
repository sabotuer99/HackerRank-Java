package algorithms.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EmasSupercompter {

    public static void log(String message){
        //System.out.println(message);
    }
    
    
    public static class Plus{
        public int x;
        public int y;
        public int len;
        
        public Plus(int row, int col, int len){
            this.y = row;
            this.x = col;
            this.len = len;
        }
        
        public int area(){
            return len * 4 + 2;
        }
        
        public boolean overlaps(Plus other){
            
            boolean overlap = false;
            overlap = overlap || (other.x == this.x && Math.abs(other.y - this.y) <= other.len + this.len);
            overlap = overlap || (other.y == this.y && Math.abs(other.x - this.x) <= other.len + this.len);
            int min = Math.min(other.len, this.len);
            int max = Math.max(other.len, this.len);
            overlap = overlap || (Math.abs(other.y - this.y) <= min && Math.abs(other.x - this.x) <= max);
            overlap = overlap || (Math.abs(other.y - this.y) <= max && Math.abs(other.x - this.x) <= min);
            
            return overlap;
        }
        
        @Override
        public String toString(){
            return String.format("<Plus len: %d, x: %d, y: %d >", len, x, y);
        }
    }
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        
        char[][] grid = new char[rows][cols];
        
        for(int row = 0; row < rows; row++){
            grid[row] = in.next().trim().toCharArray();
        }
        in.close();
        
        Map<Integer, List<Plus>> pluses = new HashMap<>();
        for(int i = 0; i < 8; i++){
            pluses.put(i, new ArrayList<Plus>());
        }
        
        //calculate all possible plus area products
        Map<Integer, String> combos = new TreeMap<>(Collections.reverseOrder());
        for(int i = 7; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int area1 = i * 4 + 1;
                int area2 = j * 4 + 1;
                int product = area1 * area2;
                String factors = i + " " + j;
                combos.put(product, factors);
            }
        }
        
        //find every possible legal plus
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 'G'){
                    int len = 0;
                    int N = row - len;
                    int S = row + len;
                    int W = col - len;
                    int E = col + len;
                    while(N >= 0 && S < rows && W >= 0 && E < cols){
                        if(grid[N][col] == 'G' && grid[row][W] == 'G' &&
                           grid[S][col] == 'G' && grid[row][E] == 'G'){
                            
                            Plus found = new Plus(row, col, len);
                            pluses.get(len).add(found);
                            
                            /*if(len > 0){
                                System.out.println(found);
                                System.out.println(pluses.get(len).size());
                            }*/  
                            
                            len++;
                            N = row - len;
                            S = row + len;
                            W = col - len;
                            E = col + len;    
                        } else {
                            break;
                        }
                    }
                } 
            }
        }
        
        //Find best combination
        for(Integer area : combos.keySet()){
            String factors = combos.get(area);
            int bigf = factors.charAt(0) - '0';
            int smlf = factors.charAt(2) - '0';

            List<Plus> bigP = pluses.get(bigf);
            List<Plus> smlP = pluses.get(smlf);
            
            log(bigf + ": " + bigP.size() + "   " + smlf + ": " + smlP.size());
            
            if(bigP.size() == 0 || smlP.size() == 0){
                continue;
            } else {
                for(Plus big : bigP){
                    for(Plus sml : smlP){
                        
                        log(big.toString() + "  |  " + sml.toString() + "  " + sml.overlaps(big));
                        
                        if(!sml.overlaps(big)){
                            System.out.println(area);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(1);
    }
}
