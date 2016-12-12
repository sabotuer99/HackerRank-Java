package algorithms.implementation;

import java.util.Scanner;

public class FlatlandSpaceStations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean spaceStation[] = new boolean[n];
        for(int c_i=0; c_i < m; c_i++){
            int city = in.nextInt();
            spaceStation[city] = true;
        }
        in.close();
        
        int[] distLeft = new int[n];
        int[] distRight = new int[n];
        
        distLeft[0] = spaceStation[0] ? 0 : Integer.MAX_VALUE;
        
        for(int i = 1; i < n; i++){
            if(spaceStation[i]){
                distLeft[i] = 0;
            } else {
                distLeft[i] = Integer.MAX_VALUE;
                if(distLeft[i-1] < Integer.MAX_VALUE){
                    distLeft[i] = distLeft[i-1] + 1;
                }
            }
        }
        
        distRight[n-1] = spaceStation[n-1] ? 0 : Integer.MAX_VALUE;
        for(int i = n-2; i >= 0; i--){
            if(spaceStation[i]){
                distRight[i] = 0;
            } else {
                distRight[i] = Integer.MAX_VALUE;
                if(distRight[i+1] < Integer.MAX_VALUE){
                    distRight[i] = distRight[i+1] + 1;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int min = Math.min(distLeft[i], distRight[i]);
            max = Math.max(min, max);
        }
        
        System.out.println(max);
    }
}
