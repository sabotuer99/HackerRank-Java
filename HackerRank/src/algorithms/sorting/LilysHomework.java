package algorithms.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LilysHomework {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] sorted = new int[n];
        int[] reversed = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
            sorted[i] = arr[i];
            reversed[i] = -arr[i];
            map.put(arr[i], i);
        }
       
        in.close();
        
        int[] diffs = new int[n];
        diffs[0] = 0;
        for(int i = 1; i < n; i++){
            diffs[i] = arr[i] - arr[0];
        }
        
        Arrays.sort(diffs);
        int pos = 0;
        int neg = 0;
        for(int diff : diffs){
            if(diff > 0){
                pos++;
            }
            if(diff < 0){
                neg++;
            }
        }
        
        boolean sortAscending = pos > neg;
        if(sortAscending){
            Arrays.sort(sorted);
        } else {
            Arrays.sort(reversed);
            for(int i = 0; i < n; i++){
                reversed[i] *= -1;
            }
            sorted = reversed;
        }
        
        int swaps = 0;
        for(int i = 0; i < n; i++){
            if(sorted[i] != arr[i]){
                swaps++;
                int target = map.get(sorted[i]);
                int temp = arr[target];
                arr[target] = arr[i];
                arr[i] = temp;
                map.put(arr[target], target);
            }
        }
        
        System.out.println(swaps);
        
        /*
        Prep stage:
        create map with:
        keys : values from input list,
        values : indexes of values from input list,
        make a copy of sorted input list
        
        Algo stage:
        Iterate through input list, and compare current value 
            (lets call it cv) against value from sorted list (lets call it scv). 
        If it is diffrent:
            increment number of swaps
            get index of the scv from map - map[scv],
            in input list swap cv with scv,
            update map[cv]=map[scv] (map[scv] does not need to be updated as we are not going to use it any more)
        */
    }
}
