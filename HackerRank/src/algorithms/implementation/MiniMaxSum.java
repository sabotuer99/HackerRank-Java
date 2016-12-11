package algorithms.implementation;

import java.util.Scanner;

public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long min = 0,max = 0,total = 0;
        for(int i = 0; i < 5; i++){
            long val = in.nextLong();
            if(i==0){
                min = val;
                max = val;
                total = val;
            } else {
                min = Math.min(min, val);
                max = Math.max(max, val);
                total += val;
            }           
        }
        System.out.printf("%d %d", total - max, total - min);
        in.close();
    }
}
