package algorithms.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargestPermutation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
            map.put(arr[i], i);
        }
        in.close();
        
        for(int i = 0; i < n; i++){
            int mx = n - i;
            if(arr[i] == mx){
                continue;
            } 
            
            int a = arr[i];
            int mx_loc = map.get(mx);
            arr[i] = mx;
            arr[mx_loc] = a;
            map.put(a, mx_loc);
            k--;
            if(k == 0){
                break;
            }

        }
        
        System.out.println(Arrays.toString(arr).replaceAll("[,\\[\\]]", ""));      
    }
}
