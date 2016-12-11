package algorithms.implementation;

import java.util.Scanner;

public class DivisibleSumPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int solutions = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if((a[i] + a[j])%k == 0){
                    solutions++;
                }
            }
        }
        System.out.println(solutions);
        in.close();
    }
}
