package algorithms.implementation;

import java.util.Scanner;

public class FindDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(; t > 0; t--){
            int N = in.nextInt();        
            int count = 0;
            
            for(int digits = N; digits > 0; digits /= 10){
                int digit = digits % 10;
                if(digit > 0 && N % digit == 0)
                    count++;
            }
            
            System.out.println(count);
        }
    }
}
