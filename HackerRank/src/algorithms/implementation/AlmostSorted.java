package algorithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AlmostSorted {

    public static class Counter{
        
        private Map<Integer, Integer> map = new HashMap<>();
        
        public void inc(int index){
            if(map.containsKey(index)){
                map.put(index, map.get(index) + 1);
            } else {
                map.put(index, 1);
            }
        }
        
        public int get(int index){
            return map.containsKey(index) ? map.get(index) : 0;
        }
        
        public Set<Integer> keySet(){
            return map.keySet();
        }
        
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        
        Map<Integer, Integer> pos = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
            pos.put(arr[i], i);
        }
        in.close();
        
        int[] sorted = new int[n];
        System.arraycopy(arr, 0, sorted, 0, n);
        Arrays.sort(sorted);
        List<Integer> ooo = new ArrayList<>();
        Counter dists = new Counter();
        
        int reconcile = 0;
        
        for(int i = 0; i < n; i++){
            int val = sorted[i];
            int orig = pos.get(val);
            if(orig != i){
                reconcile ^= Math.abs(orig - i);
                ooo.add(orig);
                dists.inc(Math.abs(orig - i));
            }
        }
        
        Collections.sort(ooo);
        
        if(reconcile == 0){
            if(ooo.size() == 2){
                System.out.println("yes\nswap " + (ooo.get(0)+1) + " " + (ooo.get(1)+1));
            } else if(ooo.size() > 2){
                boolean oneBlock = true;
                boolean distsRight = true;
                
                //must be one contiguous block
                for(int i = 0; i < ooo.size()-1; i++){
                    oneBlock = oneBlock && 
                        ((ooo.get(i+1) - ooo.get(i) == 1) || 
                        (ooo.get(i+1) - ooo.get(i) == 2 && i == ooo.size()/2 - 1));  
                }
                
                //must be exactly two of every non-zero distance
                for(Integer dist : dists.keySet()){
                    distsRight = distsRight && dists.get(dist) == 2;
                }
                
                
                if(oneBlock && distsRight){
                    System.out.println("yes\nreverse " + (ooo.get(0)+1) + " " + (ooo.get(ooo.size() - 1)+1));
                } else {
                    //System.out.println(Arrays.toString(ooo.toArray(new Integer[0])));
                    System.out.println("no");// - reverse check failed");
                }
            } else {
                System.out.println("no");// - already sorted");
            }
        } else {
            System.out.println("no");// - didn't reconcile");
        }

    }
}
