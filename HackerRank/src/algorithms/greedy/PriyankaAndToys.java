package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToys {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        in.close();
        
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int L = 0; 
        int R = 0;
        int count = 0;
        while(L < n){
            while(R < n && arr[R] <= arr[L] + 4){
                R++;
            }
            L = R;
            count++;
        }
        
        System.out.println(count);
    }
}
