package algorithms.implementation;

import java.util.Scanner;

public class EqualizeArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] counts = new int[101];
        
        for(int i = 0; i < n; i++){
            int num = in.nextInt();
            counts[num]++;
        }
        
        int max = 0;
        for(int count : counts){
            max = Math.max(max, count);
        }
        
        System.out.println(n-max);
        in.close();
    }
}
