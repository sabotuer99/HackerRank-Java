package algorithms.implementation;

import java.util.Scanner;

public class BombermanGame {

    public static String fieldToString(boolean[][] field, boolean bomb){
        StringBuilder sb = new StringBuilder();
        for(int row = 1; row < field.length-1; row++){
            for(int col = 1; col < field[0].length-1; col++){
                sb.append(field[row][col] == bomb ? 'O' : '.');
            }
            sb.append('\n');
        }
        return sb.toString().trim();
    }
    
    public static boolean[][] nextState(boolean[][] field, boolean bomb){
        boolean[][] next = new boolean[field.length][field[0].length];
        
        for(int row = 1; row < field.length-1; row++){
            for(int col = 1; col < field[0].length-1; col++){
                if(field[row][col] == bomb){
                    next[row][col-1] = true;
                    next[row][col+1] = true;
                    next[row-1][col] = true;
                    next[row+1][col] = true;
                    next[row][col] = true;
                }
            }
        }
        return next;
    }
    
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int C = in.nextInt();
        int S = in.nextInt();
        
        boolean[][] field = new boolean[R+2][C+2];
        
        String full = fieldToString(field, false);
        
        
        for(int row = 1; row <=R; row++){
            char[] state = in.next().toCharArray();
            for(int col = 1; col <= C; col++){
                field[row][col] = state[col-1] == 'O';
            }
        }
        
        String initial = fieldToString(field, true);
        boolean bomb = true;
        
        field = nextState(field, bomb);
        
        String even = fieldToString(field, !bomb);
        
        field = nextState(field, !bomb);
        String odd = fieldToString(field, !bomb);

        if(S == 1){
            System.out.println(initial + "\n");
        } else if (S%2 == 0){
            System.out.println(full + "\n");
        } else if ((S+1)%4==0){
            System.out.println(even + "\n");
        } else {
            System.out.println(odd + "\n");
        }

        in.close();
        
    }
}
