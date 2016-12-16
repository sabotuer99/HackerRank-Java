package algorithms.greedy;

import java.util.Scanner;

public class BeautifulPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[1001];
        int[] B = new int[1001];
        
        for(int i = 0; i < n; i++){
            int j = in.nextInt();
            A[j]++;
        }
        for(int i = 0; i < n; i++){
            int j = in.nextInt();
            B[j]++;
        }
        in.close();
        
        //System.out.println(Arrays.toString(A));
        //System.out.println(Arrays.toString(B));
        
        int pairs = 0;
        boolean flippable = false;
        for(int i = 0; i <= 1000; i++){
            pairs += Math.min(B[i], A[i]);
            flippable = flippable || A[i] - B[i] > 0;
        }
        pairs += flippable ? 1 : -1;
        System.out.println(pairs);
    }
}
