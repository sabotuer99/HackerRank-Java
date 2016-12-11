package algorithms.bitmanipulation;

import java.util.Scanner;

public class SansaAndXor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(; T > 0; T--){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            
            if((n & 1) == 1){
                int result = arr[0];
                for(int i = 2; i < n; i += 2){
                    result ^= arr[i];
                }
                System.out.println(result);
                
            } else {
                System.out.println(0);
            }
        }
        in.close();
    }
}
