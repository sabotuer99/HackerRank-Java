package algorithms.dp;

import java.util.Scanner;

public class Equal {

    private static int moves(int value, int target){
        int diff = value - target;
        int moves = 0;
        int[] stepSizes = {5, 2, 1};
        for(int size : stepSizes){
            int steps = diff / size;
            diff -= steps * size;
            moves += steps;
        }
        return moves;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(; T > 0; T--){
            int N = in.nextInt();
            int[] arr = new int[N];
            int base = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++){
                arr[i] = in.nextInt();
                base = Math.min(base, arr[i]);
            }
            
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++){
                int numMoves = 0;
                for(int j = 0; j < N; j++){
                    numMoves += moves(arr[j], base - i);
                }
                min = Math.min(numMoves, min);
            }
            
            System.out.println(min);
        }
        in.close();
    }
}
