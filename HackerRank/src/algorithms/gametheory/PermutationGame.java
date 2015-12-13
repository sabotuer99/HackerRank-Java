package algorithms.gametheory;

import java.util.Scanner;

public class PermutationGame {

    public static int remove(int existing, int removed){
        int bit = 1 << (removed - 1);
        return existing + bit;
    }
    
    public static int add(int existing, int added){
        int bit = 1 << (added - 1);
        return existing - bit;
    }
    
    public static boolean isIncreasing(char[] array, int mask){
        for(int i = 0; i < array.length;){
            char c1 = 0;
            for(; i < array.length && c1 == 0;i++){
                if((mask & 1) == 0){
                    c1 = array[i];
                }
                mask >>>= 1;
            }
            char c2 = 0;
            for(; i < array.length && c2 == 0;){
                if((mask & 1) == 1){
                    mask >>>= 1;
                    i++;
                } else {
                    c2 = array[i];
                }             
            }
            if(i != array.length && c1 > c2)
                return false;
        }
        return true;
    }
    
    public static boolean alreadyRemoved(int mask, int position){
        int bit = mask >> (position - 1);
        return (bit & 1) == 1;
    }
    
    public static boolean alreadyAdded(int mask, int position){
        int bit = mask >> (position - 1);
        return (bit & 1) == 0;
    }
    
    public static String printMask(int mask, int N){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i = 1; i <= N; i++){
            if((mask & 1) == 1)
                sb.append(i + " ");
            mask >>= 1;
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static boolean solve(int mask, int[] winDP, boolean[] incDP, int N){
        
        //System.out.println("Is increasing: " + incDP[mask]);
        //System.out.println(printMask(mask, N) + " " + winDP[mask]);
        
        //if we've calculated this position, just return it
        if(winDP[mask] > 0){
            return winDP[mask] == 1;
        }
        
        //if this is increasing, this is winning position
        //mark 1 for win, 2 for loss, 0 is uncalculated
        if(incDP[mask]){
            winDP[mask] = 1;
            return true;
        }
            
        
        //recurse;
        //assuming optimal play, can stop searching after getting a losing result
        //if next move wins, this move loses
        for(int i = 1; i <= N; i++){
            if(!alreadyRemoved(mask, i)){
                boolean win = !solve(remove(mask, i), winDP, incDP, N);
                winDP[mask] = win ? 1 : 2;
                if(!win)
                    break;
            } 
        }  
        
        return winDP[mask] == 1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for(; T > 0; T--){
            int N = in.nextInt();
            char[] array = new char[N];
            int mask = 0;
            for(int i = 0; i < N; i++){
                array[i] = (char)in.nextInt();
                mask <<= 1;
                mask += 1;
            }
            
            //calculate all the increasing subsequences
            boolean[] incDP = new boolean[1 << N];            
            for(int i = 0; i < incDP.length; i++){
                incDP[i] = isIncreasing(array, i);
            }
            
            //calculate winning positions
            int[] winDP = new int[1 << N];
            boolean win = false;
            for(int i = 1; i <= N && !win; i++){
                //System.out.println(i + " " + remove(0, i) + " " + printMask(remove(0, i), N));
                win = solve(remove(0, i), winDP, incDP, N);
                //if(win)
                //    System.out.println("Winning move: " + i);
            }
            
           // System.out.println(Arrays.toString(winDP));
            String winner = win ? "Alice" : "Bob";
            System.out.println(winner);
        }
        
    }
}
