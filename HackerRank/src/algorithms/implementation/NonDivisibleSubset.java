package algorithms.implementation;

import java.util.Scanner;

public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] mods = new int[n];
        for(int i = 0; i < n; i++){
            mods[i] = (int) (in.nextLong()%k);
        }
        
        int[] counts = new int[k];
        for(int mod : mods){
            counts[mod]++;
        }
        
        //System.out.println(Arrays.toString(mods));
        //System.out.println(Arrays.toString(counts));
        
        int subsets = Math.min(1, counts[0]);
        for(int i = 1; i <= k-i; i++){
            int j = k - i;
            
            //System.out.println(i + " " + j);
            if(i == j){
                subsets += Math.min(counts[i], 1);
            } else {
                subsets += Math.max(counts[i], counts[j]);
            }
            
        }
        
        System.out.println(Math.max(subsets,1));
        in.close();
    }
}
