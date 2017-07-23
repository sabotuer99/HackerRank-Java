package algorithms.implementation;

import java.util.Scanner;

public class MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        int[] counts = new int[6];
        for(int bird : ar){
            counts[bird]++;
        }
        int mostCommonType = 0;
        int mostCommonCount = 0;
        for(int i = 1; i <= 5; i++){
            if(counts[i] > mostCommonCount){
                mostCommonType = i;
                mostCommonCount = counts[i];
            }
        }
        return mostCommonType;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
        in.close();
    }
}
