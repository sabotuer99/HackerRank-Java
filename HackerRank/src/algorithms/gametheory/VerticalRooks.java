import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int T = in.nextInt(); T > 0; T--){
            int n = in.nextInt();
            int[] heaps = new int[n];
            for(int i = 0; i < n; i++){
                heaps[i] = in.nextInt();
            }
            int nimSum = 0;
            int[] hash = new int[n];
            for(int i = 0; i < n; i++){
                hash[i] = (Math.abs(heaps[i] - in.nextInt()) - 1);
                nimSum ^= hash[i];
            }
            int omoves = 0;
            for(int i = 0; i < n; i++){
                omoves += (nimSum ^ hash[i]) < hash[i] ? 1 : 0;
            }
            
            System.out.println(omoves%2 == 0 ? "player-1" : "player-2");
        }
    }
}
