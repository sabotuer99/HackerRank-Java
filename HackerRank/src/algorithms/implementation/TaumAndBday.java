package algorithms.implementation;

import java.util.Scanner;

public class TaumAndBday {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int t = in.nextInt(); t > 0; t--){
            long B = in.nextLong();
            long W = in.nextLong();
            long X = in.nextLong();
            long Y = in.nextLong();
            long Z = in.nextLong();
            
            X = Math.min(X, (Y + Z));
            Y = Math.min(Y, (X + Z));
            
            System.out.println(B * X + W * Y);
              
        }
    }
}
