package algorithms.implementation;

import java.util.Scanner;

public class StrangeCounter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long target = in.nextLong();
        
        long time = 1;
        long value = 3;
        
        while(time + value <= target){
            time += value;
            value *= 2;
        }
        
        System.out.println(value - (target - time));
        in.close();
    }
}
