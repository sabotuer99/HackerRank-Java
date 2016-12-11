package algorithms.implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BetweenTwoSets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        int minB = Integer.MAX_VALUE;
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
            minB = Math.min(minB, b[b_i]);
        }
        
        int[] factors = new int[101];
        for(int anum : a){
            for(int i = anum; i <=minB; i += anum){
                factors[i] += 1;
            }
        }
        
        Set<Integer> between = new HashSet<>();
        
        //System.out.println(Arrays.toString(factors));
        
        for(int i = 0; i <= minB; i++){
            int factorCount = factors[i];
            if(factorCount == n && i <= minB){
                boolean match = true;
                for(int bnum : b){
                    match = match && bnum%i == 0;
                }
                
                if(match){
                    between.add(i);
                }
            }
        }
        
        System.out.println(between.size());       
        in.close();
    }
}
