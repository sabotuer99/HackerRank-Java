package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class CuttingBoards {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(; T > 0; T--){
            int width = in.nextInt();
            int height = in.nextInt();
            long[] vcuts = new long[width-1];
            long[] hcuts = new long[height-1];
            for(int i = 0; i < vcuts.length; i++){
                vcuts[i] = in.nextLong();
            }
            for(int i = 0; i < hcuts.length; i++){
                hcuts[i] = in.nextLong();
            }
            
            Arrays.sort(vcuts);
            Arrays.sort(hcuts);
            
            long vCount = 1;
            long hCount = 1;
            
            int vindex = vcuts.length - 1;
            int hindex = hcuts.length - 1;
            long cost = 0;
            
            while(vindex >= 0 || hindex >= 0){
                if(vindex < 0){
                    cost += hcuts[hindex] * vCount;
                    //System.out.printf("Horizontal cut for cost %d across %d segments, total: %d \n", 
                    //                      hcuts[hindex], vCount, cost);
                    hindex--;
                } else if(hindex < 0){
                    cost += vcuts[vindex] * hCount;
                    //System.out.printf("Vetical cut for cost %d across %d segments, total: %d \n", 
                    //                      vcuts[vindex], hCount, cost);
                    vindex--;
                } else {
                    if(vcuts[vindex] > hcuts[hindex] || (vcuts[vindex] == hcuts[hindex])){
                        cost += vcuts[vindex] * hCount;
                        //System.out.printf("Vetical cut for cost %d across %d segments, total: %d \n", 
                        //                  vcuts[vindex], hCount, cost);
                        vCount++;
                        vindex--;
                    } else {
                        cost += hcuts[hindex] * vCount;
                        //System.out.printf("Horizontal cut for cost %d across %d segments, total: %d \n", 
                        //                  hcuts[hindex], vCount, cost);
                        hCount++;
                        hindex--;
                    }
                }
            }
            
            System.out.println(cost%1000000007);
            
        }
        in.close();
        
    }
    
}
