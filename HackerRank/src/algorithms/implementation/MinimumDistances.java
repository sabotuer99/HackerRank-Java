package algorithms.implementation;

import java.util.Scanner;

public class MinimumDistances {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        in.close();
        
        int[] lastSeen = new int[100001];
        for(int i = 0; i < lastSeen.length; i++){
            lastSeen[i] = -1;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++){
            int val = A[i];
            if(lastSeen[val] != -1){
                min = Math.min(i - lastSeen[val], min);
            }
            lastSeen[val] = i;
        }
        
        if(min == Integer.MAX_VALUE){
            min = -1;
        }
        
        System.out.println(min);
    }
}
